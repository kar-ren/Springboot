package com.techprimers.repository;

import com.techprimers.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Long> {
    List<Todos> findByOwnerId(Long id);
}
