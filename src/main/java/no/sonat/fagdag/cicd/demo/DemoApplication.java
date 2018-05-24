package no.sonat.fagdag.cicd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	@Autowired
//	private PersonRepository personRepository;
//
//	@PostConstruct
//	public void init() {
//		personRepository.saveAll(IntStream.rangeClosed(1, 10).mapToObj(p ->
//				new Person(generateRandomString(), generateRandomString()))
//        .collect(Collectors.toList()));
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
