package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.erp.model.ToDo;

public class ToDoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ToDoRepository() {

	}

	public ToDoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public ToDo getOne(Long id) {
		return manager.find(ToDo.class, id);
	}
	
	public List<ToDo> getAll() {
         return manager.createQuery("from ToDo", ToDo.class).getResultList();
    }

	public ToDo store(ToDo toDo) {
		return manager.merge(toDo);
	}

	public void remove(ToDo toDo) {
		toDo = getOne(toDo.getId());
		manager.remove(toDo);
	}
}