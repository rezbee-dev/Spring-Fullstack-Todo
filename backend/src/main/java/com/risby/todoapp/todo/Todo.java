package com.risby.todoapp.todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Column(nullable = false)
    private String title;

    private String desc;

    @Min(value=1, message="Priority can only be values 1-3")
    @Max(value=3, message="Priority can only be values 1-3")
    @Column(nullable = false, columnDefinition = "integer default 1")
    private Integer priority;

    @FutureOrPresent
    private LocalDateTime due;
    // Todo: write test to confirm default value = false

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean done = false;

    @ManyToMany
    @JoinTable(name="Todo_Category",
                joinColumns = @JoinColumn(name = "todo_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<TodoCategory> categories;

    public Todo() {
    }

    public Todo(String title, String desc, Integer priority, LocalDateTime due, Boolean done) {
        this.title = title;
        this.desc = desc;
        this.priority = priority;
        this.due = due;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Set<TodoCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<TodoCategory> categories) {
        this.categories = categories;
    }
}
