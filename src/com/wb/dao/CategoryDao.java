package com.wb.dao;

import java.util.List;

import com.wb.entity.Category;
import com.wb.util.DBPage;

public interface CategoryDao {
	/** 添加新闻类别 */
	int addCategory(Category category);
	/**删除新闻类别*/
	int delCategory(int cid);
	/**查询全部新闻类别*/
	List<Category> allCategory();
	/**查询单条新闻类别*/
	Category getCategory(Category category);
	/**修改新闻类别*/
	int modifyCategory(Category category);
	/**分頁*/
	DBPage<Category> queryByPage(DBPage<Category> dbPage);
}
