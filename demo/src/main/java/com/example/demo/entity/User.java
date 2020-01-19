package com.example.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Id;

//@Table
@Component
public class User  extends  BaseEntity{

    @Id
    private  Integer id;
    private  String name;
    private Integer age;
    private String tel;

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                '}';
    }

    public User(String createTime, Integer id, String name, Integer age, String tel) {
        super(createTime);
        this.id = id;
        this.name = name;
        this.age = age;
        this.tel = tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
