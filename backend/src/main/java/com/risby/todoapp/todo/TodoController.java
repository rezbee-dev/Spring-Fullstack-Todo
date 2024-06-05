package com.risby.todoapp.todo;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/api/todos", produces = "application/json")
public class TodoController {
    private final TodoRepo repo;

    @Autowired
    public TodoController(TodoRepo repo){
        this.repo = repo;
    }

    @GetMapping
    @Operation(summary = "Returns all todos")
    public ResponseEntity<List<Todo>> findAll(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Creates new todo")
    public ResponseEntity<Todo> save(@RequestBody Todo todo){
        try {
            return new ResponseEntity<>(repo.save(todo), HttpStatus.CREATED);
        } catch (Exception e) {
            // Note, Java bean validation will trigger MethodArgumentNotValidException
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to save todo item");
        }
    }
}
