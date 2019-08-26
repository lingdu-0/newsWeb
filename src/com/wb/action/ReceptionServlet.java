package com.wb.action;

import com.wb.entity.Category;
import com.wb.entity.News;
import com.wb.service.impl.CategoryServiceImpl;
import com.wb.service.impl.NewsServiceImpl;
import com.wb.util.DBPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 处理前台请求
 */
@WebServlet("/reception")
public class ReceptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		session.setAttribute("sdf",sdf);
		NewsServiceImpl newsServiceImpl = new NewsServiceImpl();
		CategoryServiceImpl cateService = new CategoryServiceImpl();
		Category cate;
		News news;
		List<News> newsList;
		int pageNo;
		String dbPageNo;
		DBPage<News> dbPage = new DBPage<>();
		String flag = req.getParameter("flag");
		if (flag == null || "".equals(flag)) {
			flag = "0";
		}
		switch (Integer.valueOf(flag)) {
		case 0:// 加载Index界面
			news = new News();
			cate = new Category();
			dbPageNo = (String) req.getParameter("pageNo");
			if (dbPageNo == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.valueOf(dbPageNo);
			}
			dbPage.setCurrPageNo(pageNo);
			newsServiceImpl.queryByPage(dbPage);
			session.setAttribute("cateList", cateService.allCategory());
			session.setAttribute("dbPage", dbPage);
			session.setAttribute("pageNo", pageNo);
			resp.sendRedirect("Index.jsp");
			break;
		case 1:// 打开新闻跳转info界面
			news = new News();
			cate = new Category();
			Integer nid = Integer.valueOf(req.getParameter("nid"));
			news.setNid(nid);
			newsList = newsServiceImpl.getNews(news);
			session.setAttribute("news", newsList.get(0));
			resp.sendRedirect("Info.jsp");
			break;
		case 2:// 点击新闻类别按类别检索并跳转list界面
			news = new News();
			cate = new Category();
			Integer cid = Integer.valueOf(req.getParameter("cid"));
			cate = cateService.getCategoryById(cid);
			//news.setNcategory(cate.getCname());
			session.setAttribute("cate",cate);
			session.setAttribute("cateList", cateService.allCategory());
			dbPageNo = req.getParameter("pageNo");
			if (dbPageNo == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.valueOf(dbPageNo);
			}
			dbPage.setCurrPageNo(pageNo);
			newsServiceImpl.queryCate(dbPage, cate.getCname());
			session.setAttribute("dbPage", dbPage);
			session.setAttribute("pageNo", pageNo);
			resp.sendRedirect("List.jsp");
			break;
		case 3://按条件搜索
			String lastTitle =(String) session.getAttribute("lastTitle");
			String ntitle = req.getParameter("ntitle");
			if ("".equals(ntitle)||ntitle==null)
				ntitle=lastTitle;
			dbPageNo = req.getParameter("pageNo");
			if (dbPageNo == null) {
				pageNo = 1;
			} else {
				pageNo = Integer.valueOf(dbPageNo);
			}
			dbPage.setCurrPageNo(pageNo);
			session.setAttribute("lastTitle",ntitle);
			newsServiceImpl.queryTitle(dbPage, ntitle);
			session.setAttribute("dbPage", dbPage);
			session.setAttribute("pageNo", pageNo);
			session.setAttribute("sdf",sdf);
			resp.sendRedirect("Search.jsp");
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
