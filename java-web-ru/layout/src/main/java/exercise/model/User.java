package exercise.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public final class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public User(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
