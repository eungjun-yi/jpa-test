import javax.persistence.GeneratedValue;
import javax.persistence.Id;

class Person {
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
