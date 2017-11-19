package tn.esprit.volunteering.volunteering.services;

import javax.ejb.Remote;

import tn.esprit.volunteering.volunteering.persistence.User;

@Remote
public interface UserServiceRemote {

	public void saveUser(User user);
}
