package com.wb.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wb.entity.Category;
import com.wb.entity.News;
import com.wb.service.impl.CategoryServiceImpl;
import com.wb.service.impl.NewsServiceImpl;
import com.wb.util.DBPage;

/**
 * 新闻类别处理
 */
@WebServlet("/Manager/News/cate")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryServiceImpl cateService = new CategoryServiceImpl();
        HttpSession session = request.getSession();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        session.setAttribute("sdf",sdf);
        int cid = 0;
        String cname = null;
        Category cate = null;
        String flag = request.getParameter("flag");
        System.out.println(flag);
        switch (Integer.valueOf(flag)) {
            case 0:// 增加新闻
                cname = request.getParameter("cname");
                cate = new Category(0, cname);
                cateService.addCategory(cate);
                refreshList(request, response, session);
                break;
            case 1:// 修改新闻
                cid = Integer.valueOf(request.getParameter("cid"));
                cname = request.getParameter("cname");
                cate = new Category(cid, cname);
                cateService.updateCategory(cate);
                refreshList(request, response, session);
                break;
            case 2:// 删除新闻
                cid = Integer.valueOf(request.getParameter("cid"));
                cateService.delCategory(cid);
                refreshList(request, response, session);
                break;
            case 3://查询全部新闻记录
                refreshList(request, response, session);
                break;
            case 4://跳转修改界面.
                cid = Integer.valueOf(request.getParameter("cid"));
                cate = cateService.getCategoryById(cid);
                session.setAttribute("cate", cate);
                response.sendRedirect("CategoryModify.jsp");
                break;
        }

    }

    private void refreshList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        CategoryServiceImpl cateServiceImpl = new CategoryServiceImpl();
        DBPage<Category> dbPage = new DBPage<>();
        int pageNo;
        String dbPageNo = request.getParameter("pageNo");
        if (dbPageNo == null) {
            pageNo = 1;
        } else {
            pageNo = Integer.valueOf(dbPageNo);
        }
        dbPage.setCurrPageNo(pageNo);
        cateServiceImpl.queryByPage(dbPage);
        session.setAttribute("dbPage", dbPage);
        session.setAttribute("pageNo", pageNo);
        response.sendRedirect(request.getContextPath() + "/Manager/News/CategoryList.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
