package com.example.rest.springrestws.JpaDynamicexample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JUserDaoService {

	private static List<JUser> users = new ArrayList<JUser>();

	private static int countuser = 5;
	static {
		users.add(new JUser(1, "pramod", new Date()));
		users.add(new JUser(2, "gautam", new Date()));
		users.add(new JUser(3, "Ajay", new Date()));
		users.add(new JUser(4, "Amit", new Date()));
		users.add(new JUser(5, "naveen", new Date()));
	}

	public List<JUser> findAll() {
		return users;
	}

	public JUser save(JUser user) {
		if (user.getId() == null)
			user.setId(++countuser);
		users.add(user);

		return user;
	}

	public JUser findOne(int id) {
		for (JUser user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;

	}

	public JUser deleteById(int id) {
		Iterator<JUser> itr = users.iterator();

		while (itr.hasNext()) {
			JUser user = itr.next();
			if (user.getId() == id)
			{
				itr.remove();
				return user;
			}	
		}

		return null;

	}
}
