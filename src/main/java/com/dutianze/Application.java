package com.dutianze;

import com.dutianze.dao.GroupRepository;
import com.dutianze.model.Event;
import com.dutianze.model.Group;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author dutianze
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final GroupRepository repository;

    public Application(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Denver JUG", "Utah JUG", "Seattle JUG", "Richmond JUG")
              .forEach(name -> repository.save(new Group(name)));

        Group group = repository.findByName("Denver JUG");
        Event e = Event.builder().title("Full Stack Reactive")
                       .description("Reactive with Spring Boot + React")
                       .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                       .build();
        group.setEvents(Collections.singleton(e));
        repository.save(group);
        repository.findAll().forEach(System.out::println);
    }
}
