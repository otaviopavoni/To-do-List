package com.todo.todo.services;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> create(Todo todo){
        repository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending());
        return repository.findAll(sort);
    }

    public List<Todo> update(Todo todo){
        repository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        repository.deleteById(id);
        return list();
    }
}
