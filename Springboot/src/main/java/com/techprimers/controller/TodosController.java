package com.techprimers.controller;

import com.techprimers.model.Todos;
import com.techprimers.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodosController {

    /** The JPA repository */
    @Autowired
    TodosService todosService;


    @GetMapping("/todos")
    @ResponseBody
    public List<Todos> getTodosID(@RequestParam(required = false) Long ownerId) {
        List<Todos> lists = todosService.findByOwnerId(ownerId);
        if(lists == null){
            lists = (List<Todos>) todosService.findAll();
        }
        return lists;
    }

    @GetMapping(value = "/todos/{id}")
    public Todos findById(@PathVariable final Long id){
        return todosService.findById(id);
    }

    @PostMapping(value = "/todos")
    protected Todos load(@RequestBody final Todos todos) {
        return todosService.save(todos);
    }

    @PutMapping(value = "/todos/{id}")
    public Todos putMap(@PathVariable final Long id, @RequestBody Todos todos){
        return todosService.update(todos, id);
    }

    @DeleteMapping(value = "/todos/{id}")
    public void deleteUser(@PathVariable final Long id){
        todosService.deleteUser(id);
    }
}
