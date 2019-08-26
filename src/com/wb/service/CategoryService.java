package com.wb.service;

import java.util.List;

import com.wb.entity.Category;
import com.wb.util.DBPage;

public interface CategoryService {
	/** 查询全部新闻类别 */
	List<Category> allCategory();

	/** 根据编号加载新闻类别 */
	Category getCategoryById(int cid);

	/** 添加新闻 类别*/
	int addCategory(Category category);

	/** 修改新闻 类别*/
	int updateCategory(Category category);

	/** 删除新闻类别 */
	int delCategory(int cid);

	/** 分頁 */
	DBPage<Category> queryByPage(DBPage<Category> dbPage);
}
