package com.turkcell.spring_starter.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
   // @GeneratedValue(strategy = GenerationType.IDENTITY) -> 1'er 1'er artan strateji.
   @Id
   @UuidGenerator()
   @Column(name="id")
   private UUID id;

   @Column(name="name", nullable = false, length = 100)
   private String name;

   @Column(name="description", length = 500)
   private String description;

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

   public String getDescription() {
    return description;
   }

   public void setDescription(String description) {
    this.description = description;
   }

}
