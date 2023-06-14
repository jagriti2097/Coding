package com.glo.app.controller;

import com.glo.app.exception.CustomerNotFoundException;
import com.glo.app.exception.FieldNullException;
import com.glo.app.model.Customer;
import com.glo.app.model.Product;
import com.glo.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer)  {
        try {
            return customerService.add(customer);
        } catch (FieldNullException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{customerId}")
    public Customer addProductsToCustomer(@PathVariable int customerId, @RequestBody List<Product> products) throws CustomerNotFoundException, FieldNullException {
        if (ObjectUtils.isEmpty(customerId))
            throw new FieldNullException("Customer id cannot be empty");
        if (ObjectUtils.isEmpty(products))
            throw new FieldNullException("Product list cannot be empty");
        for(Product product: products)
            if (ObjectUtils.isEmpty(product.getProductName()) || ObjectUtils.isEmpty(product.getProductPrice()))
                throw new FieldNullException("Product details cannot be empty. Check: " + product);
        return customerService.addProducts(customerId, products);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) throws FieldNullException, CustomerNotFoundException {
        if (ObjectUtils.isEmpty(customerId))
            throw new FieldNullException("Customer id cannot be empty");
        return customerService.delete(customerId);
    }
}
