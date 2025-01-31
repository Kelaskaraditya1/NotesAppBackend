package com.StarkIndustries.NotesAppBackend.Authentication.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "profile_pic_url")
    private String profilePicUrl;

    public Profile(int userId,String name,String email,String username,String password,String profilePicUrl){
        this.userId=userId;
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=password;
        this.profilePicUrl=profilePicUrl;
    }

    public Profile(String name,String email,String username,String password,String profilePicUrl){
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=password;
        this.profilePicUrl=profilePicUrl;
    }

    public Profile(String username,String password){
        this.username=username;
        this.password=password;
    }

    public Profile(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                '}';
    }
}
