package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String fullName;
    private Integer age;
    private String email;
    private String password;
    private LocalDate registrationDate;
    private List<Order> orderList=new ArrayList<>();



}
