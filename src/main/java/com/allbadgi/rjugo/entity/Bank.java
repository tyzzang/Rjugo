package com.allbadgi.rjugo.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    public Bank() {}
    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
