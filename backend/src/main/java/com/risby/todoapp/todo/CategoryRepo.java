package com.risby.todoapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    // implemented via derived queries
    @Transactional
    public void deleteByLabel(String label);
}
