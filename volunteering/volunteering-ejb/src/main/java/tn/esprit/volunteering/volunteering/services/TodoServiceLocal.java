package tn.esprit.volunteering.volunteering.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.volunteering.volunteering.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
