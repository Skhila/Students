package ge.bacho.students.students.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class University {
    private final int id;
    private String name, location;

    public University(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
