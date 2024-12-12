package com.example.day39exercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "area is required")
    private String area;

    @NotEmpty(message = "street is required")
    private String street;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;


}
