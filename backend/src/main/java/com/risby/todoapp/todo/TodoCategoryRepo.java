package com.risby.todoapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TodoCategoryRepo extends JpaRepository<TodoCategory, Long> {

    // implemented via derived queries
    @Transactional
    public void deleteByCategory(String category);
}
