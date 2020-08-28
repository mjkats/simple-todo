package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.erp.model.ToDo;
import com.algaworks.erp.repository.ToDoRepository;
import com.algaworks.erp.service.ToDoService;

@Named
@ViewScoped
public class ToDoManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ToDoRepository toDos;

	@Inject
	private ToDoService toDoService;

	private List<ToDo> toDoList;

	private ToDo toDo;

	public void createToDo() {
		toDo = new ToDo();
	}

	public void save() {
		toDo.setCompleted("F");
		toDo.setName(toDo.getName());

		toDoService.save(toDo);
	}

	public void allToDos() {
		toDoList = toDos.getAll();
	}

	public List<ToDo> getToDoList() {
		return toDoList;
	}

	public ToDo getToDo() {
		return toDo;
	}

}