package Soccer_Resort_Mngmt;

import java.time.LocalDate;

public class Guest {

    private String name;
    private LocalDate dob;
    private Country country;
    private Language language;
    private Hobby hobby;

    public Guest() {
    }

    public Guest(String name, LocalDate dob, Country country, Language language, Hobby hobby) {
        this.name = name;
        this.dob = dob;
        this.country = country;
        this.language = language;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Country getCountry() {
        return country;
    }

    public Language getLanguage() {
        return language;
    }

    public Hobby getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", country=" + country +
                ", language=" + language +
                ", hobby=" + hobby +
                '}';
    }
}

enum Country{
    USA, Spain, Germany, France, China
}

enum Hobby{
    Eat, Drink, WaterSports, Dance, Read, Music
}

enum Language{
    English, Spanish, French, Chinese, German
}