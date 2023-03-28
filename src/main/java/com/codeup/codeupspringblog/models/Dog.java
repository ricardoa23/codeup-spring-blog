package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private long id;
    @Column(nullable = false, columnDefinition = "tinyint(3) unsigned ")
    private byte age;
    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String name;
    @Column(name = "reside_state", columnDefinition = "char(2) DEFAULT 'XX'")
    private String resideState;

    public Dog() {}

    public Dog(long id, byte age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
