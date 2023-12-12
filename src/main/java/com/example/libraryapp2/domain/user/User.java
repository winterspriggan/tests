package com.example.libraryapp2.domain.user;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20,name = "name") //name varchar(20)
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(
                    String.format("잘못된  name(%s)이 들어왔습니다",name)
            );
        }
        this.name = name;
        this.age = age;
    }

    public User() {

    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) { this.name = name;
    }
}
