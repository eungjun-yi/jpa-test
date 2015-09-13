package eungjun;

import javax.persistence.*;

/**
 * @author Yi EungJun <eungjun.yi@gmail.com>
 */
@Entity
public class Membership {

    @GeneratedValue
    @Id
    Long id;

    @ManyToOne
    private Team team;

    private String level;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
