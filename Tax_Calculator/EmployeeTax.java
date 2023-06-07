package Tax_Calculator;

import java.util.Scanner;

public class EmployeeTax {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter the employee's earnings: ");
        double amount = s.nextDouble();

        double incomeTax = calculateIncomeTax(amount);
        System.out.println("Income tax to be paid by the employee: " + incomeTax);
    }

    public static double calculateIncomeTax(double earnings) {
        double incomeTax = 0;

        if (earnings <= 50000) {
            incomeTax = 0;
        } else if (earnings <= 60000) {
            incomeTax = 0.1 * (earnings - 50000);
        } else if (earnings <= 150000) {
            incomeTax = 0.1 * (10000) + 0.2 * (earnings - 60000);
        } else {
            incomeTax = 0.1 * (10000) + 0.2 * (90000) + 0.3 * (earnings - 150000);
        }

        return incomeTax;
    }
}