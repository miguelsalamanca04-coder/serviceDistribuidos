package com.mathservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    
    private String id;
    private String firstName;
    private String lastName;
    private int age;

}
