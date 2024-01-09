package exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public final class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public String toString() {
        return "User(" + this.getId() + ", " + this.getFirstName() + " " + this.getLastName() + ", " + this.getEmail() + ")";
    }
}
