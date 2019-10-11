package com.techprimers.service;

import com.techprimers.model.Todos;

import java.util.List;

public interface TodosService {

    Todos findById(Long id);

    Todos save(Todos todos);

    Todos update(Todos todos, Long id);

    void deleteUser(Long id);

    List<Todos> findByOwnerId(Long id);

    List<Todos> findAll();
}
