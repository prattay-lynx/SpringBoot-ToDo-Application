package com.example.springboot3todoapplication.Models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class ToDoClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Boolean isComplete;

    // public Boolean isComplete() {
    // return isComplete;
    // }

    // public void setComplete(Boolean isComplete) {
    // this.isComplete = isComplete;
    // }

    private Instant createdAt;

    private Instant updatedAt;

    // public Long getId() {
    // return id;
    // }

    // public void setId(Long id) {
    // this.id = id;
    // }

    // public String getDescription() {
    // return description;
    // }

    // public void setDescription(String description) {
    // this.description = description;
    // }

    // // public boolean isComplete() {
    // // return isComplete;
    // // }

    // // public void setComplete(boolean isComplete) {
    // // this.isComplete = isComplete;
    // // }

    // // public boolean getComplete() {
    // // return isComplete;
    // // }

    // public Instant getCreatedAt() {
    // return createdAt;
    // }

    // public void setCreatedAt(Instant createdAt) {
    // this.createdAt = createdAt;
    // }

    // public Instant getUpdatedAt() {
    // return updatedAt;
    // }

    // public void setUpdatedAt(Instant updatedAt) {
    // this.updatedAt = updatedAt;
    // }

    public String toString() {
        return String.format("TodoItem{id='%d',description='%s', isComplete='%s, createdAt='%s', updatedAt='%s'}",
                id, description, isComplete, createdAt, updatedAt);
    }

}
