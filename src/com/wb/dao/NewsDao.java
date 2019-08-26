package com.wb.dao;

import java.util.List;

import com.wb.entity.News;
import com.wb.util.DBPage;

public interface NewsDao {
	/** 添加新闻 */
	int addNews(News news);
	/**删除新闻*/
	int delNews(int nid);
	/**查询全部新闻*/
	List<News> allNews();
	/**查询单条新闻*/
	List<News> getNews(News news);
	/**修改新闻*/
	int modifyNews(News news);
	/**无条件分页查询全部数据*/
	DBPage<News> queryByPage(DBPage<News> dbPage);
	/**分页查询*/
	DBPage<News> pageQuery(DBPage<News> dbPage, String sql1, String sql2);
	/**按类别查询*/
	DBPage<News> queryCate(DBPage<News> dbPage,String ncategory);
	/**条件查询*/
	DBPage<News> queryTitle(DBPage<News> dbPage,String ntitle);
}
