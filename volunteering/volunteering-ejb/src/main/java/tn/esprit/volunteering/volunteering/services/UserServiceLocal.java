package tn.esprit.volunteering.volunteering.services;

import javax.ejb.Local;

import tn.esprit.volunteering.volunteering.persistence.User;

@Local
public interface UserServiceLocal {

	public void saveUser(User user);
}
