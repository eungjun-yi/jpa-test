package eungjun;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi EungJun <eungjun.yi@gmail.com>
 */
@Entity
public class Team {

    @GeneratedValue
    @Id
    Long id;

    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Membership> members = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Membership> getMembers() {
        return members;
    }

    public Long getId() {
        return id;
    }
}
