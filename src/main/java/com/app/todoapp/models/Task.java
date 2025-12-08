package com.app.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // @Entity Annotation: This annotation, from the javax.persistence package, marks a Java class as an entity, indicating that it should be mapped to a database table.
// Primary Key (@Id): Every entity must have a primary key that uniquely identifies each record in the database table. This is defined by annotating a field with @Id.
// Primary Key Generation (@GeneratedValue): To automatically generate primary key values, the @GeneratedValue annotation can be used. Common strategies include GenerationType.IDENTITY (for auto-incrementing columns) or GenerationType.AUTO (allowing the persistence provider to choose).
@Data // The @Data annotation in Spring Boot is a Project Lombok annotation that serves as a convenient shortcut for generating boilerplate code in Plain Old Java Objects (POJOs) and data transfer objects (DTOs).
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean completed;
}
