package org.example.hibernate.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FightingStadion {
    @Column
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FightingStadion that = (FightingStadion) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "FightingStadion{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
