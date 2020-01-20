package ru.mail.dimaushenko.service.model;


public class FullUserDTO {

    private int id;
    private String username;
    private String password;
    private boolean isActive;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FullUserDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", isActive=" + isActive + ", age=" + age + '}';
    }

}
