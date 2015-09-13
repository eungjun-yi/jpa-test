package eungjun;

import javax.persistence.Entity;

/**
 * @author Yi EungJun <eungjun.yi@gmail.com>
 */
@Entity
public class Membership {
    private Team team;
    private String level;
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
