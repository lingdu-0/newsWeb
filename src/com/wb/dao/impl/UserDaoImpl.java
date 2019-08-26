package com.wb.dao.impl;

import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import com.wb.dao.UserDao;
import com.wb.entity.User;
import com.wb.util.DBUtil;

public class UserDaoImpl extends DBUtil implements UserDao {
	/**
	 * 查询根据用户名或编号单个用户
	 */
	@Override
	public User getUser(User user) {
		int uid = 0;
		String uname = null;
		String upwd = null;
		if (user.getUid() != 0) {
			CachedRowSet crs = this.execQuery("select * from t_user where uid = ?", user.getUid());
			if (crs.size() == 0) {
				return null;
			} else {
				try {
					while (crs.next()) {
						uname = crs.getString("uname");
						upwd = crs.getString("upwd");
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return new User(0, uname, upwd);
			}
		} else if (user.getUname() != null) {
			CachedRowSet crs = this.execQuery("select * from t_user where uname = ?", user.getUname());
			if (crs.size() == 0) {
				return null;
			} else {
				try {
					while (crs.next()) {
						uid = crs.getInt("uid");
						uname = crs.getString("uname");
						upwd = crs.getString("upwd");
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return new User(uid, uname, upwd);
			}
		}
		return null;
	}

	@Override
	public List<User> listUser() {
		return null;
	}

	@Override
	public int addUser(User user) {
		String sql ="insert into t_user (uname,upwd) values(?,?)";
		Object[] args = { user.getUname(), user.getUpwd()};
		return this.execUpdate(sql,args);
	}

	@Override
	public int deleteUser(int uid) {
		return 0;
	}

	@Override
	public int modifyUser(User user) {
		return 0;
	}
}
