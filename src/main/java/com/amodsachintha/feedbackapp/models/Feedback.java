package com.amodsachintha.feedbackapp.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;


@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String info;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Service service;

    private Date createdAt;
    private Date updatedAt;

    public Feedback() {
    }

    public Feedback(String info, Service service) {
        this.info = info;
        this.service = service;
        this.createdAt = Date.from(Instant.now());
        this.updatedAt = Date.from(Instant.now());
    }

    // Update Object
    public Feedback(String info, Service service, Date updatedAt) {
        this.info = info;
        this.service = service;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
        return "Feedback{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", person=" + person.toString() +
                ", service=" + service.toString() +
                '}';
    }
}
