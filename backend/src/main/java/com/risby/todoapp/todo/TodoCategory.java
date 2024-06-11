package com.risby.todoapp.todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "Category")
public class TodoCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cannot be blank")
    @Column(nullable = false, unique = true)
    private String category;

    @ManyToMany(mappedBy = "categories")
    private Set<Todo> todos;

    public TodoCategory() {
    }

    public TodoCategory(String category,Set<Todo> todos) {
        this.category = category;
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }
}
