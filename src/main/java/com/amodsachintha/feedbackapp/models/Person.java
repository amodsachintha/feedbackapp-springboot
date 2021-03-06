package com.amodsachintha.feedbackapp.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName;
    private String lName;
    private String nic;
    private String mobile;
    private String address;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Set<Feedback> feedbacks = new HashSet<>();

    @OneToOne
    private Region region;

    public Person() {
    }

    public Person(String fName, String lName, String nic, String mobile, String address, Region region) {
        this.fName = fName;
        this.lName = lName;
        this.nic = nic;
        this.mobile = mobile;
        this.address = address;
        this.region = region;
        this.createdAt = Date.from(Instant.now());
        this.updatedAt = Date.from(Instant.now());
    }

    public Person(String fName, String lName, String nic, String mobile, String address, Date updatedAt, Set<Feedback> feedbacks, Region region) {
        this.fName = fName;
        this.lName = lName;
        this.nic = nic;
        this.mobile = mobile;
        this.address = address;
        this.updatedAt = updatedAt;
        this.feedbacks = feedbacks;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", nic='" + nic + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", region=" + region.toString() +
                '}';
    }
}
