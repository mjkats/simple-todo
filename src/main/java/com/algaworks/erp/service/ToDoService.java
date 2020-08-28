package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.ToDo;
import com.algaworks.erp.repository.ToDoRepository;
import com.algaworks.erp.util.Transacional;

public class ToDoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ToDoRepository toDos;

    @Transacional
    public void save(ToDo toDo) {
        toDos.store(toDo);
    }

    @Transacional
    public void delete(ToDo toDo) {
        toDos.remove(toDo);
    }

}