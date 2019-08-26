package com.wb.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wb.entity.News;
import com.wb.service.impl.CategoryServiceImpl;
import com.wb.service.impl.NewsServiceImpl;
import com.wb.util.DBPage;

@WebServlet("/Manager/News/news")
public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsServiceImpl newsService = new NewsServiceImpl();
        CategoryServiceImpl cateService = new CategoryServiceImpl();
        HttpSession session = request.getSession();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        session.setAttribute("sdf",sdf);
        int nid = 0;
        String ntitle = null;
        String ncontent = null;
        String ncategory = null;
        News news = new News();
        String flag = request.getParameter("flag");
        System.out.println(flag);
        switch (Integer.valueOf(flag)) {
            case 0:// 增加新闻
                ntitle = request.getParameter("ntitle");
                ncategory = request.getParameter("ncategory");
                ncontent = request.getParameter("ncontent");
                news = new News(0, ntitle, ncontent, ncategory, new Date());
                newsService.addNews(news);
                refreshList(request, response, session);
                break;
            case 1:// 修改新闻
                nid = Integer.valueOf(request.getParameter("nid"));
                ntitle = request.getParameter("ntitle");
                ncategory = request.getParameter("ncategory");
                ncontent = request.getParameter("ncontent");
                news = new News(nid, ntitle, ncontent, ncategory, new Date());
                newsService.updateNews(news);
                session.setAttribute("cateList", cateService.allCategory());
                refreshList(request, response, session);
                break;
            case 2:// 删除新闻
                nid = Integer.valueOf(request.getParameter("nid"));
                newsService.delNews(nid);
                refreshList(request, response, session);
                break;
            case 3://查询全部新闻记录
                refreshList(request, response, session);
                break;
            case 4://跳转修改界面
                nid = Integer.valueOf(request.getParameter("nid"));
                news.setNid(nid);
                List<News> newsList = newsService.getNews(news);
                session.setAttribute("news", newsList.get(0));
                session.setAttribute("cateList", cateService.allCategory());
                response.sendRedirect("NewsModify.jsp");
                break;
            case 5://跳转添加界面
                session.setAttribute("cateList", cateService.allCategory());
                response.sendRedirect("NewsAdd.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void refreshList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        NewsServiceImpl newsServiceImpl = new NewsServiceImpl();
        DBPage<News> dbPage = new DBPage<>();
        int pageNo;
        String dbPageNo = request.getParameter("pageNo");
        if (dbPageNo == null) {
            pageNo = 1;
        } else {
            pageNo = Integer.valueOf(dbPageNo);
        }
        dbPage.setCurrPageNo(pageNo);
        newsServiceImpl.queryByPage(dbPage);
        session.setAttribute("dbPage", dbPage);
        session.setAttribute("pageNo", pageNo);
        response.sendRedirect(request.getContextPath() + "/Manager/News/NewsList.jsp");
    }
}
