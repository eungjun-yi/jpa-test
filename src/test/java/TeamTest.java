import eungjun.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasItem;
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
        team.getMembers().add(person);
        teamRepository.save(team);

        team = teamRepository.findOne(team.getId());
        assertThat(team.getMembers(), hasItem(person));
    }
}
