package Soccer_Resort_Mngmt;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EventManager {
    static List<Guest> guestList = new ArrayList<>();

    public static void main(String[] args) {

        populateGuestList();
        guestList.forEach(System.out::println);
        filterGuests();

    }

    private static void filterGuests(){
        Predicate<Guest> fromSpain = guest -> guest.getCountry() == Country.Spain;
        Predicate<Guest> loveMusicAndDance = guest -> (guest.getHobby() == Hobby.Music || guest.getHobby() == Hobby.Dance);
        Predicate<Guest> loveDrinkAgeAbove18 = guest -> guest.getHobby() == Hobby.Drink & Period.between(guest.getDob(),LocalDate.now()).getYears()>18;
        Predicate<Guest> fromFrance = guest -> guest.getCountry() == Country.France;
        Predicate<Guest> loveSports = guest -> guest.getHobby() == Hobby.WaterSports;
        Predicate<Guest> speakChinese = guest -> guest.getLanguage() == Language.Chinese;
        Predicate<Guest> loveReading = guest -> guest.getHobby() == Hobby.Read;
        Predicate<Guest> above18 = guest -> Period.between(guest.getDob(),LocalDate.now()).getYears()>18;

        System.out.println("From Spain, Loves Music or Dance");
        guestList.stream().filter(fromSpain).filter(loveMusicAndDance).forEach(System.out::println);

        System.out.println("From Spain, Loves Drink and are above 18 years of age");
        guestList.stream().filter(fromSpain).filter(loveDrinkAgeAbove18).forEach(System.out::println);

        System.out.println("From France, Loves WaterSports");
        guestList.stream().filter(fromFrance).filter(loveSports).forEach(System.out::println);

        System.out.println("Speak Chinese and loves to read");
        guestList.stream().filter(speakChinese).filter(loveReading).forEach(System.out::println);

        System.out.println("Number of guests of age above 70 years");
        System.out.println(guestList.stream().filter(above18).count());

    }
    private static List<Guest> populateGuestList(){

        guestList.add(new Guest("Guest1",LocalDate.of(1997,7,20),Country.Spain,Language.Spanish,Hobby.Eat));
        guestList.add(new Guest("Guest2",LocalDate.of(1945,5,13) ,Country.USA,Language.English,Hobby.Dance));
        guestList.add(new Guest("Guest3",LocalDate.of(1856,12,22) ,Country.Spain,Language.Spanish,Hobby.Drink));
        guestList.add(new Guest("Guest4",LocalDate.of(1998,11,11) ,Country.France,Language.French,Hobby.WaterSports));
        guestList.add(new Guest("Guest5",LocalDate.of(1890,9,5) ,Country.Germany,Language.German,Hobby.Read));
        guestList.add(new Guest("Guest6",LocalDate.of(1934,3,4) ,Country.China,Language.Chinese,Hobby.Read));
        guestList.add(new Guest("Guest7",LocalDate.of(1856,12,22) ,Country.Spain,Language.Spanish,Hobby.Dance));

        return guestList;
    }


}
