package com.example.demo.space;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface SpaceShipRepository extends FirestoreReactiveRepository<SpaceShip> {


}
