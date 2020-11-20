package com.example.demo.space;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpaceShipRepositoryTest {

    @Autowired
    SpaceShipRepository repository;

    @Test
    public void testStoreData(){
        repository.deleteAll().block();
        SpaceShip.SpaceShipBuilder builder = SpaceShip.builder()
                .model("pyramid")
                .captain("Chad")
                .fuel(43);

        repository.save(builder.build()).block();
        repository.save(builder.captain("Susan").build()).block();
        repository.save(builder.model("cube").build()).block();
        repository.save(builder.captain("Paul").fuel(88).build()).block();
        repository.save(builder.captain("Ulla").fuel(67).build()).block();

        Flux<SpaceShip> all = repository.findAll();
        all.doOnNext(
                spaceship -> System.out.println("Yes we got a ship: " + spaceship)
        )
        .doOnComplete(() -> System.out.println("We are done!"))
        .blockLast();
    }

}