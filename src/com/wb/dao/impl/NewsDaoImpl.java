package com.wb.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.wb.dao.NewsDao;
import com.wb.entity.News;
import com.wb.util.DBPage;
import com.wb.util.DBUtil;

public class NewsDaoImpl extends DBUtil implements NewsDao {

	/**
	 * 添加新闻
	 */
	@Override
	public int addNews(News news) {
		String sql = "insert into t_news(ntitle,ncontent,ncategory,ndate) values(?,?,?,now())";
		Object[] args = { news.getNtitle(), news.getNcontent(), news.getNcategory() };
		return this.execUpdate(sql, args);
	}

	/**
	 * 删除新闻
	 */
	@Override
	public int delNews(int nid) {
		String sql = "delete from t_news where nid=?";
		Object[] args = { nid };
		return this.execUpdate(sql, args);
	}

	/**
	 * 查询全部新闻
	 */
	@Override
	public List<News> allNews() {
		String sql = "select nid,ntitle,ncontent,ncategory,ndate from t_news";
		List<News> list = new ArrayList<News>();
		CachedRowSet crs = this.execQuery(sql);
		try {
			while (crs.next()) {
				News news = new News(crs.getInt(1), crs.getString(2), crs.getString(3), crs.getString(4),
						crs.getDate(5));
				list.add(news);
			}
			crs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询指定新闻
	 */
	@Override
	public List<News> getNews(News news) {
		News news2 = null;
		List<News> list = new ArrayList<>();
		if (news.getNid() != 0) {
			CachedRowSet crs = this.execQuery("select * from t_news where nid = ?", news.getNid());
			if (crs.size() != 0) {
				try {
					while (crs.next()) {
						news2 = new News(crs.getInt(1), crs.getString(2), crs.getString(3), crs.getString(4),
								crs.getDate(5));
						list.add(news2);
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		} else if (news.getNtitle() != null) {
			CachedRowSet crs = this.execQuery("select * from t_news where ntitle = ?", news.getNtitle());
			if (crs.size() != 0) {
				try {
					while (crs.next()) {
						news2 = new News(crs.getInt(1), crs.getString(2), crs.getString(3), crs.getString(4),
								crs.getDate(5));
						list.add(news2);
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		} else if (news.getNcategory() != null) {
			CachedRowSet crs = this.execQuery("select * from t_news where ncategory = ?", news.getNcategory());
			if (crs.size() != 0) {
				try {
					while (crs.next()) {
						news2 = new News(crs.getInt(1), crs.getString(2), crs.getString(3), crs.getString(4),
								crs.getDate(5));
						list.add(news2);
					}
					crs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		}
		return null;
	}

	/**
	 * 修改新闻
	 */
	@Override
	public int modifyNews(News news) {
		String sql = "update t_news set ntitle=?,ncontent=?,ncategory=?,ndate=? where nid=?";
		Object[] args = { news.getNtitle(), news.getNcontent(), news.getNcategory(), news.getNdate(), news.getNid() };
		return this.execUpdate(sql, args);
	}

	/**
	 * 分页查询所有数据
	 */
	@Override
	public DBPage<News> queryByPage(DBPage<News> dbPage) {
		String sql1 = "select count(1) from t_news";
		String sql2 = "select * from t_news limit ?,?";
		return pageQuery(dbPage, sql1, sql2);
	}

	/**
	 * 分页查询
	 */
	@Override
	public DBPage<News> pageQuery(DBPage<News> dbPage, String sql1, String sql2) {
		CachedRowSet crs1 = this.execQuery(sql1);
		try {
			while (crs1.next()) {
				dbPage.setTotalCount(crs1.getInt(1));
			}
			crs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CachedRowSet crs2 = this.execQuery(sql2, (dbPage.getCurrPageNo() - 1) * dbPage.getPageSize(),
				dbPage.getPageSize());
		try {
			while (crs2.next()) {
				News news = new News(crs2.getInt(1), crs2.getString("ntitle"), crs2.getString("ncontent"),
						crs2.getString("ncategory"), crs2.getDate("ndate"));
				dbPage.getList().add(news);
			}
			crs2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbPage;
	}

	/**
	 * 按类别查询
	 */
	@Override
	public DBPage<News> queryCate(DBPage<News> dbPage, String ncategory) {
		String sql1 = "select count(1) from t_news where ncategory= '" + ncategory+"'";
		String sql2 = "select * from t_news where ncategory= '" + ncategory + "' limit ?,?";
		return pageQuery(dbPage, sql1, sql2);
	}

	@Override
	public DBPage<News> queryTitle(DBPage<News> dbPage, String ntitle) {
		String sql1 = "select count(1) from t_news where concat (ntitle,ncontent) like '%" + ntitle + "%'";
		String sql2 = "select * from t_news  where concat (ntitle,ncontent) like '%" + ntitle + "%' limit ?,?";
		return pageQuery(dbPage, sql1, sql2);
	}

}
