package com.example.springboot3todoapplication.Services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot3todoapplication.Models.ToDoClass;
import com.example.springboot3todoapplication.Repositories.TodoItemRepository;

@Service
public class ToDoService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<ToDoClass> getAll() {
        return todoItemRepository.findAll();
    }

    public Optional<ToDoClass> getByID(Long id) {
        return todoItemRepository.findById(id);
    }

    public ToDoClass save(ToDoClass todoitem) {
        if (todoitem.getId() == null) {
            todoitem.setCreatedAt(Instant.now());
        }

        todoitem.setUpdatedAt(Instant.now());
        return todoItemRepository.save(todoitem);
    }

    public void delete(ToDoClass todoitem) {
        todoItemRepository.delete(todoitem);
    }

}
