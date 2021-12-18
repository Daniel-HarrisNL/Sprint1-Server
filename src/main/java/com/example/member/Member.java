package com.example.member;

import javax.persistence.*;

@Entity
public class Member {


    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String startDate;
    private String duration;
    private String membership;
    //TODO: Pull membership out into it's own class to track ID's in a @OneToMany relationship,
    // such that 'Family' memberships can be shared among multiple members.


    //Member ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //TODO: Add ManyToMany relationship for connecting registered tournamnets
    //https://www.youtube.com/watch?v=ntN1HWKND8U&ab_channel=CodeForgeYT
    //https://www.youtube.com/watch?v=eQsXQBiXXsg&ab_channel=CodeForgeYT

    //Member Name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Member Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Member Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Member Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //Member Start Date
    //TODO: Convert startDate to proper date type.
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    //Member Duration
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    //Member Membership Type
    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}