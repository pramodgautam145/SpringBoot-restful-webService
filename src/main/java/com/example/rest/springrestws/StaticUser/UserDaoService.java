package com.example.rest.springrestws.StaticUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int countuser = 5;
	static {
		users.add(new User(1, "pramod", new Date()));
		users.add(new User(2, "gautam", new Date()));
		users.add(new User(3, "Ajay", new Date()));
		users.add(new User(4, "Amit", new Date()));
		users.add(new User(5, "naveen", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null)
			user.setId(++countuser);
		users.add(user);

		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;

	}

	public User deleteById(int id) {
		Iterator<User> itr = users.iterator();

		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id)
			{
				itr.remove();
				return user;
			}	
		}

		return null;

	}
}
