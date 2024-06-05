package ex2;

import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
public class User {
    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String country;

    public User(String firstName, String lastName, int age, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }
}
