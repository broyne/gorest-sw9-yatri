package com.gorest.model;

public class Userpojo {
    private String name;
    private String email;
    private String gender;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String status;
    public static Userpojo getUserPojo(String name, String email, String gender, String status){
        Userpojo userPojo = new Userpojo();
        userPojo.setStatus(status);
        userPojo.setGender(gender);
        userPojo.setEmail(email);
        userPojo.setName(name);

        return userPojo;
    }
}
