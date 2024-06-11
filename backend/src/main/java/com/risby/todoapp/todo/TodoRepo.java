package com.risby.todoapp.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepo extends JpaRepository<Todo, Long> {
    public Page<Todo> findByCategoriesLabelIgnoreCase(String label, Pageable page);
    public Page<Todo> findByDone(Boolean done, Pageable page);
    public Page<Todo> findByPriority(Integer priority, Pageable page);
}
