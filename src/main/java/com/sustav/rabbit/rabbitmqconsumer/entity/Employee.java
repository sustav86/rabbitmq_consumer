package com.sustav.rabbit.rabbitmqconsumer.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sustav.rabbit.rabbitmqconsumer.json.CustomDateDeserializer;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Employee {

    @JsonProperty(value = "employee_id")
    private String employeeId;
    private String name;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDate birthDate;

    public Employee(String employeeId, String name, LocalDate birthDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Employee() {
    }
}
