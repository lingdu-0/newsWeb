package com.wb.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import com.wb.dao.CategoryDao;
import com.wb.entity.Category;
import com.wb.util.DBPage;
import com.wb.util.DBUtil;

public class CategoryDaoImpl extends DBUtil implements CategoryDao {

	@Override
	public int addCategory(Category category) {
		String sql = "insert into t_category(cname) values(?)";
		Object[] args = { category.getCname() };
		return this.execUpdate(sql, args);
	}

	@Override
	public int delCategory(int cid) {
		String sql = "delete from t_category where cid=?";
		Object[] args = { cid };
		return this.execUpdate(sql, args);
	}

	@Override
	public List<Category> allCategory() {
		String sql = "select cid,cname from t_category";
		List<Category> list = new ArrayList<Category>();
		CachedRowSet crs = this.execQuery(sql);
		try {
			while (crs.next()) {
				Category cate = new Category(crs.getInt(1), crs.getString(2));
				list.add(cate);
			}
			crs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Category getCategory(Category cate) {
		Category category = null;
		if (cate.getCid() != 0) {
			CachedRowSet crs = this.execQuery("select * from t_category where cid = ?", cate.getCid());
			if (crs.size() == 0) {
				return null;
			} else {
				try {
					while (crs.next()) {
						category = new Category(crs.getInt(1), crs.getString(2));
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return category;
			}
		} else if (cate.getCname() != null) {
			CachedRowSet crs = this.execQuery("select * from t_category where cname = ?", cate.getCname());
			if (crs.size() == 0) {
				return null;
			} else {
				try {
					while (crs.next()) {
						category = new Category(crs.getInt(1), crs.getString(2));
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return category;
			}
		}
		return null;
	}

	@Override
	public int modifyCategory(Category category) {
		String sql = "update t_category set cname=? where cid=?";
		Object[] args = { category.getCname(), category.getCid() };
		return this.execUpdate(sql, args);
	}

	@Override
	public DBPage<Category> queryByPage(DBPage<Category> dbPage) {
		CachedRowSet crs1 = this.execQuery("select count(1) from t_category");
		try {
			while (crs1.next()) {
				dbPage.setTotalCount(crs1.getInt(1));
			}
			crs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CachedRowSet crs2 = this.execQuery("select * from t_category limit ?,?",
				(dbPage.getCurrPageNo() - 1) * dbPage.getPageSize(), dbPage.getPageSize());
		try {
			while (crs2.next()) {
				Category cate = new Category(crs2.getInt(1), crs2.getString(2));
				dbPage.getList().add(cate);
			}
			crs2.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbPage;
	}
}
