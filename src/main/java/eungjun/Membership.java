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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Membership that = (Membership) o;

        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        return !(person != null ? !person.equals(that.person) : that.person != null);

    }

    @Override
    public int hashCode() {
        int result = team != null ? team.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }
}
