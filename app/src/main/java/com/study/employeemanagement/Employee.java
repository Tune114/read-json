package com.study.employeemanagement;

public class Employee {
    private String name;
    private int age;
    private String email;
    private String phone;
    private int image;
    private String imageLink;

    public Employee(String name, int age, String email, String phone, int image) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public Employee(String name, int age, String email, String phone, String imageLink) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.imageLink = imageLink;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
