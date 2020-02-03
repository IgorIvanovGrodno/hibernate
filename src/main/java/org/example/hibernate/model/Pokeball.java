package org.example.hibernate.model;

import javax.persistence.*;

@Entity
public class Pokeball {
    @Column
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public Pokeball(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
