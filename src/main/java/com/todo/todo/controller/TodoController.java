package com.todo.todo.controller;

import com.todo.todo.model.Todo;
import com.todo.todo.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public List<Todo> create(@RequestBody Todo todo){
        return service.create(todo);
    }

    @GetMapping
    public List<Todo> list(){
        return service.list();
    }

    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return service.update(todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable("id") Long id){
        return service.delete(id);
    }
}
