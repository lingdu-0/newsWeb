package com.wb.service.impl;

import java.util.List;

import com.wb.dao.UserDao;
import com.wb.dao.impl.UserDaoImpl;
import com.wb.entity.User;
import com.wb.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();
	@Override
	public User login(User user) {
		return dao.getUser(user);
	}

	@Override
	public List<User> listUser() {
		return null;
	}

	@Override
	public int regUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public int deleteUser(int uid) {
		return 0;
	}

	@Override
	public int modifyUser(User user) {
		return 0;
	}

	@Override
	public User getUser(User user) {
		return dao.getUser(user);
	}

}
