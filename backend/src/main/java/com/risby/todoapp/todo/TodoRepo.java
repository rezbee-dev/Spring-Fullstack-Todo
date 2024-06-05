package com.risby.todoapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {
}
