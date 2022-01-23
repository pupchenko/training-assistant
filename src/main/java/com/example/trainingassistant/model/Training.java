package com.example.trainingassistant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trainings")
@JsonIgnoreProperties({"userId"})
public class Training {
    @Id
    private String id;
    @Indexed
    private String userId;
    @NotNull
    private Instant date;
    @Valid
    @NotEmpty
    private List<Exercise> exercises;
}
