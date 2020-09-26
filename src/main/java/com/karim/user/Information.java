package com.karim.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Embeddable
public class Information {
    @Column(name = "WEBSITE")
    private String webSite;

    @Column(name = "BIO")
    private String bio;

    @Column(name = "PHONE")
    private long phone;

    @Column(name = "GENDER")
    private String gender;


}
