package com.risby.todoapp.todo;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/todos/categories", produces = "application/json")
public class TodoCategoryController {
    private final TodoCategoryRepo repo;

    @Autowired
    public TodoCategoryController(TodoCategoryRepo repo){
        this.repo = repo;
    }

    @GetMapping
    @Operation(summary = "Returns Todo Categories")
    public ResponseEntity<List<TodoCategory>> findAll(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Creates new Todo Category")
    public ResponseEntity<TodoCategory> save(@RequestBody TodoCategory todoCategory){
        try {
            return new ResponseEntity<>(repo.save(todoCategory), HttpStatus.CREATED);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to save todo category");
        }
    }

    @DeleteMapping()
    @Operation(summary = "Deletes Todo Category by Category")
    public void removeByCategory(@RequestBody Map<String, String> body){
        System.out.println(body.get("category"));
        repo.deleteByCategory(body.get("category"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes Todo Category by Id")
    public void removeByCategory(@PathVariable Long id){
        repo.deleteById(id);
    }
}
