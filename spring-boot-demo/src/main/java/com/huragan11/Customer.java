package com.huragan11;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private long id;
    private String name;
    private String email;
    private Integer age;

    public Customer(long id, String name, String email, Integer age) {
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer() {
    }

    public void setEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
