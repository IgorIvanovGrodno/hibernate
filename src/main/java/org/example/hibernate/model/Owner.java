package org.example.hibernate.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {
    private static final long serialVersionUID=1L;
    @Column
    private String name;

    @Access(value=AccessType.FIELD)
    @Column
    int age;
    @Column
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Owner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return age == owner.age &&
                Objects.equals(name, owner.name) &&
                Objects.equals(status, owner.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, status);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}
