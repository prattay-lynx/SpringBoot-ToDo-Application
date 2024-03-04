package com.example.springboot3todoapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot3todoapplication.Models.ToDoClass;
import com.example.springboot3todoapplication.Services.ToDoService;

import jakarta.validation.Valid;

@Controller
public class TodoFormController {

    @Autowired
    private ToDoService todoItemservice;

    @GetMapping("/create-todo")
    public String showCreateForm(Model model) {
        model.addAttribute("todoItem", new ToDoClass());
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createToDoItem(@Valid ToDoClass todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Handle validation errors if needed
            return "new-todo-item";
        }

        ToDoClass item = new ToDoClass();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemservice.save(item);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        ToDoClass todoItem = todoItemservice.getByID(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoItem id: " + id + " not Found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";

    }

    @GetMapping("/delete/{id}")
    public String deletetodoItem(@PathVariable("id") Long id, Model model) {
        ToDoClass todoItem = todoItemservice.getByID(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoItem id: " + id + " not Found"));

        todoItemservice.delete(todoItem);
        return "redirect:/";

    }

    @PostMapping("/todo/{id}")
    public String UpdatetodoItem(@PathVariable("id") Long id, @Valid ToDoClass todoitem, BindingResult result,
            Model model) {
        ToDoClass item = todoItemservice.getByID(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoItem id: " + id + " not Found"));
        item.setIsComplete(item.getIsComplete());

        item.setDescription(item.getDescription());

        todoItemservice.save(item);

        return "redirect:/";
    }

}
