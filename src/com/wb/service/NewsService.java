package com.wb.service;

import java.util.List;

import com.wb.entity.News;
import com.wb.util.DBPage;

public interface NewsService {
	/** 查询全部新闻 */
	List<News> allNews();

	/** 根据编号加载新闻 */
	List<News> getNews(News news);

	/** 添加新闻 */
	int addNews(News news);

	/** 修改新闻 */
	int updateNews(News news);

	/** 删除新闻 */
	int delNews(int nid);

	/** 无条件分页查询 */
	DBPage<News> queryByPage(DBPage<News> dbPage);

	/** 按类别查询 */
	DBPage<News> queryCate(DBPage<News> dbPage, String ncategory);

	/** 条件查询 */
	DBPage<News> queryTitle(DBPage<News> dbPage, String ntitle);
}
