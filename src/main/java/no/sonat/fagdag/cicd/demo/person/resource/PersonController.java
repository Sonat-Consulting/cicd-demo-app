package no.sonat.fagdag.cicd.demo.person.resource;

import lombok.extern.slf4j.Slf4j;
import no.sonat.fagdag.cicd.demo.person.Person;
import no.sonat.fagdag.cicd.demo.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("persons")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        log.info("Creating person -> {}", person.toString());
        return personRepository.save(person);
    }

    @GetMapping("{personId}")
    public Person get(@PathVariable long personId) {
        log.info("Fetching person by id {}", personId);
        return personRepository.getOne(personId);
    }

    @GetMapping
    public List<Person> get() {
        log.info("Fetching all persons");
        return personRepository.findAll();
    }
}
