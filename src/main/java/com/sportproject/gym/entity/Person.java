package com.sportproject.gym.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Egor on 12.05.2020.
 */
@Entity()
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private int age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Person_Gymnastic",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "gymnastic_id"))
    private Set<Gymnastic> gymnastics;

    public Person() {
    }


    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public Set<Gymnastic> getGymnastics() {
        return this.gymnastics;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGymnastics(Set<Gymnastic> gymnastics) {
        this.gymnastics = gymnastics;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        if (this.getAge() != other.getAge()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        result = result * PRIME + this.getAge();
        return result;
    }

    public String toString() {
        return "Person(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ")";
    }
}