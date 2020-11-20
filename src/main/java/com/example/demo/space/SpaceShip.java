package com.example.demo.space;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collectionName = "mikespaceship")
public class SpaceShip {
    @DocumentId
    private String id;
    private String model;
    private String captain;
    private Integer fuel;
}
