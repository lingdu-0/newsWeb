package com.wb.service.impl;

import java.util.List;

import com.wb.dao.NewsDao;
import com.wb.dao.impl.NewsDaoImpl;
import com.wb.entity.News;
import com.wb.service.NewsService;
import com.wb.util.DBPage;

public class NewsServiceImpl implements NewsService {

	NewsDao dao = new NewsDaoImpl();

	@Override
	public List<News> allNews() {
		return dao.allNews();
	}

	@Override
	public List<News> getNews(News news) {
		return dao.getNews(news);
	}

	@Override
	public int addNews(News news) {
		return dao.addNews(news);
	}

	@Override
	public int updateNews(News news) {
		return dao.modifyNews(news);
	}

	@Override
	public int delNews(int nid) {
		return dao.delNews(nid);
	}

	@Override
	public DBPage<News> queryByPage(DBPage<News> dbPage) {
		return dao.queryByPage(dbPage);
	}

	@Override
	public DBPage<News> queryCate(DBPage<News> dbPage, String ncategory) {
		return dao.queryCate(dbPage, ncategory);
	}

	@Override
	public DBPage<News> queryTitle(DBPage<News> dbPage, String ntitle) {
		return dao.queryTitle(dbPage, ntitle);
	}

}
