package com.wb.service.impl;

import java.util.List;
import com.wb.dao.CategoryDao;
import com.wb.dao.impl.CategoryDaoImpl;
import com.wb.entity.Category;
import com.wb.service.CategoryService;
import com.wb.util.DBPage;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao dao = new CategoryDaoImpl();

	@Override
	public List<Category> allCategory() {
		return dao.allCategory();
	}

	@Override
	public Category getCategoryById(int cid) {
		Category category = new Category();
		category.setCid(cid);
		return dao.getCategory(category);
	}

	@Override
	public int addCategory(Category category) {
		return dao.addCategory(category);
	}

	@Override
	public int updateCategory(Category category) {
		return dao.modifyCategory(category);
	}

	@Override
	public int delCategory(int cid) {
		return dao.delCategory(cid);
	}

	@Override
	public DBPage<Category> queryByPage(DBPage<Category> dbPage) {
		return dao.queryByPage(dbPage);
	}

}
