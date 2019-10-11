package com.techprimers.service;

import com.techprimers.model.Todos;
import com.techprimers.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosServiceImpl implements TodosService{

    @Autowired
    TodosRepository todosRepository;

    @Override
    public List<Todos> findAll() {
        List<Todos> todos = todosRepository.findAll();
        if (todos == null){
            new RuntimeException();
        }
        return todos;
    }

    @Override
    public Todos findById(Long id) {
        Todos todos = todosRepository.findOne(id);
        if (todos == null){
            new RuntimeException();
        }
        return todos;
    }

    @Override
    public Todos save(Todos todos) {
        todos = todosRepository.save(todos);
        if (todos == null){
            new RuntimeException();
        }
        return todos;
    }

    @Override
    public Todos update(Todos todos, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        Todos test = todosRepository.findOne(id);
        if (test != null) {
            todosRepository.delete(id);
        }else{
            new RuntimeException();
        }
    }

    @Override
    public List<Todos> findByOwnerId(Long id) {
        return todosRepository.findByOwnerId(id);
    }


}
