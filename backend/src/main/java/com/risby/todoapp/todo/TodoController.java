package com.risby.todoapp.todo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @Operation(summary = "Returns unsorted Todo items of particular page (default = 0) and size (default = 3)")
    @Parameter(name = "page", allowEmptyValue = true)
    @Parameter(name = "size", allowEmptyValue = true)
    public ResponseEntity<List<Todo>> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
        PageRequest p = PageRequest.of(page,size);
        Page<Todo> pg = repo.findAll(p);

        System.out.println(pg.getTotalElements());
        System.out.println(pg.getTotalPages());

        return new ResponseEntity<>(pg.stream().toList(), HttpStatus.OK);
    }

    @GetMapping("/category")
    @Operation(summary = "Filters todos by Category (default='') of particular page (default = 0) and size (default = 3)")
    @Parameter(name = "page", allowEmptyValue = true)
    @Parameter(name = "size", allowEmptyValue = true)
    @Parameter(name = "value", allowEmptyValue = true)
    public ResponseEntity<List<Todo>> findAllByCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String value){
        PageRequest p = PageRequest.of(page,size);
        Page<Todo> pg;

        if(value.isEmpty()) pg = repo.findAll(p);
        else pg = repo.findByCategoriesLabelIgnoreCase(value, p);

        return new ResponseEntity<>(pg.stream().toList(), HttpStatus.OK);
    }

    @GetMapping("/completed")
    @Operation(summary = "Filters todos by Completion status (default=false) of particular page (default = 0) and size (default = 3)")
    @Parameter(name = "page", allowEmptyValue = true)
    @Parameter(name = "size", allowEmptyValue = true)
    @Parameter(name = "value", allowEmptyValue = true)
    public ResponseEntity<List<Todo>> findAllByCompletion(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "false") Boolean value){
        PageRequest p = PageRequest.of(page,size);
        Page<Todo> pg = repo.findByDone(value, p);

        return new ResponseEntity<>(pg.stream().toList(), HttpStatus.OK);
    }

    @GetMapping("/priority")
    @Operation(summary = "Filters todos by Priority (default=None) of particular page (default = 0) and size (default = 3)")
    @Parameter(name = "page", allowEmptyValue = true)
    @Parameter(name = "size", allowEmptyValue = true)
    @Parameter(name = "value", allowEmptyValue = true)
    public ResponseEntity<List<Todo>> findAllByPriority(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") Integer value){
        PageRequest p = PageRequest.of(page,size);
        Page<Todo> pg;

        if(value > 3 || value < 1) pg = repo.findAll(p);
        else pg = repo.findByPriority(value, p);

        return new ResponseEntity<>(pg.stream().toList(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Creates new Todo")
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
