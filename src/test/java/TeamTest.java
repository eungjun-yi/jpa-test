import eungjun.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Yi EungJun <eungjun.yi@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
public class TeamTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void create() {
        Team team = new Team();
        team.setName("blue");
        teamRepository.save(team);

        team = teamRepository.findOne(team.getId());
        assertThat(team.getName(), is("blue"));
    }

    @Test
    public void addMember() {
        Team team = new Team();
        team.setName("blue");
        Person person = new Person();
        person.setName("yi");
        Membership membership = new Membership();
        membership.setTeam(team);
        membership.setPerson(person);
        membership.setLevel("admin");
        team.getMembers().add(membership);
        teamRepository.save(team);

        team = teamRepository.findOne(team.getId());
        assertThat(team.getMembers(), hasItem(membership));
    }

    @Test
    public void addMemberConcurrently() {
        Team team = new Team();
        team.setName("red");
        team = teamRepository.save(team);

        {
            Person person = new Person();
            person.setName("kim");
            Membership membership = new Membership();
            membership.setTeam(team);
            membership.setPerson(person);
            membership.setLevel("admin");
            team.getMembers().add(membership);
            team = teamRepository.save(team);
        }

        {
            Person person = new Person();
            person.setName("kim");
            Membership membership = new Membership();
            membership.setTeam(team);
            membership.setPerson(person);
            membership.setLevel("member");
            team.getMembers().add(membership);
            team = teamRepository.save(team);
        }

        team = teamRepository.findOne(team.getId());
        assertThat(team.getMembers(), hasSize(1));
    }

}
