package eungjun;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Person {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
