package com.wb.dao;

import java.util.List;

import com.wb.entity.User;

/** 用户信息访问接口 */
public interface UserDao {
	/** 查询指定用户 */
	User getUser(User user);

	/** 查询全部用户 */
	List<User> listUser();

	/** 添加用户 */
	int addUser(User user);

	/** 删除用户 */
	int deleteUser(int uid);

	/** 修改用户信息 */
	int modifyUser(User user);
}
