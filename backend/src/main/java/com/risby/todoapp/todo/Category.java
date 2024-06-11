package com.risby.todoapp.todo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cannot be blank")
    @Column(nullable = false, unique = true)
    private String label;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private Set<Todo> todos;

    public Category() {
    }

    public Category(String category, Set<Todo> todos) {
        this.label = category;
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return label;
    }

    public void setCategory(String label) {
        this.label = label;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }
}
