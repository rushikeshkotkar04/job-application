package com.Jobportal.Jobportal.entities;


import jakarta.persistence.*;

@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String mobile;
    public String email;
    @Lob
    private byte[] resume;

    public Info(String name, String mobile, String email, byte[] resume) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.resume = resume;
    }
}
