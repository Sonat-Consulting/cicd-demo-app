package no.sonat.fagdag.cicd.demo.person;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static no.sonat.fagdag.cicd.demo.RunUtils.generateRandomString;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        personRepository.saveAll(IntStream.rangeClosed(1, 10).mapToObj(p ->
                new Person(generateRandomString(), generateRandomString())).collect(Collectors.toList()));

        Assert.assertFalse("There should be ten people in the database",
                personRepository.findAll().isEmpty());
    }
}
