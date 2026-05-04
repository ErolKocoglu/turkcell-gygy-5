package com.turkcell.library_cqrs.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Officer {
    @Id
    @UuidGenerator()
    @Column(name="id")
    private UUID id;

    private String name;
    private String job;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "issuedBy")
    private List<Borrow> issuedBorrows;

    @OneToMany(mappedBy = "receivedBy")
    private List<Borrow> receivedBorrows;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Borrow> getIssuedBorrows() {
        return issuedBorrows;
    }

    public void setIssuedBorrows(List<Borrow> issuedBorrows) {
        this.issuedBorrows = issuedBorrows;
    }

    public List<Borrow> getReceivedBorrows() {
        return receivedBorrows;
    }

    public void setReceivedBorrows(List<Borrow> receivedBorrows) {
        this.receivedBorrows = receivedBorrows;
    }

    
}
