package com.example.trainingassistant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exercises")
public class Exercise {
    @Id
    private String name;
    @NotBlank
    private String displayName;
    @NotBlank
    private String description;
}

