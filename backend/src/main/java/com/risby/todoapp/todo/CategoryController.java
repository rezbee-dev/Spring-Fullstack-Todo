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
public class CategoryController {
    private final CategoryRepo repo;

    @Autowired
    public CategoryController(CategoryRepo repo){
        this.repo = repo;
    }

    @GetMapping
    @Operation(summary = "Returns Todo Categories")
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Creates new Todo Category")
    public ResponseEntity<Category> save(@RequestBody Category category){
        try {
            return new ResponseEntity<>(repo.save(category), HttpStatus.CREATED);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to save todo category");
        }
    }

    @DeleteMapping()
    @Operation(summary = "Deletes Todo Category by Category")
    public void removeByCategory(@RequestBody Map<String, String> body){
        System.out.println(body.get("label"));
        repo.deleteByLabel(body.get("label"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes Todo Category by Id")
    public void removeByCategory(@PathVariable Long id){
        repo.deleteById(id);
    }
}
