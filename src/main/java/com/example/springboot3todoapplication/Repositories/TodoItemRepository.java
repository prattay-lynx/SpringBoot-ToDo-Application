package com.example.springboot3todoapplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot3todoapplication.Models.ToDoClass;

// refrencing and handling my todoitem
@Repository
public interface TodoItemRepository extends JpaRepository<ToDoClass, Long> {

}
