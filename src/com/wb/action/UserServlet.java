package com.wb.action;

import com.wb.entity.User;
import com.wb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 注册处理
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		session.setAttribute("sdf",sdf);
		String name = null;
		String pwd = null;
		String flag = req.getParameter("flag");

		switch (Integer.valueOf(flag)) {
		case 0:
			name = req.getParameter("name");
			if (name != null && !"".equals(name)) {
				UserServiceImpl userServiceImpl = new UserServiceImpl();
				User user = new User(0, name, "");
				if (userServiceImpl.getUser(user) != null) {
					resp.getWriter().append("{\"nameJudge\":" + false + "}");
				} else {
					resp.getWriter().append("{\"nameJudge\":" + true + "}");
				}
			}
			break;
		case 1:
			name = req.getParameter("name");
			pwd = req.getParameter("pwd");
			if (name != null && !"".equals(name) && pwd != null && !"".equals(pwd)) {
				UserServiceImpl userServiceImpl = new UserServiceImpl();
				User user = new User(0, name, pwd);
				if (userServiceImpl.getUser(user) != null) {
					resp.getWriter().append("{\"nameJudge\":" + false + "}");
				} else {
					userServiceImpl.regUser(user);
					resp.sendRedirect("Manager/Login.jsp");
				}
			}
			break;
		case 2:
			name = req.getParameter("name");
			pwd = req.getParameter("pwd");
			if (name != null && !"".equals(name) && pwd != null && !"".equals(pwd)) {
				UserServiceImpl userServiceImpl = new UserServiceImpl();
				User user = new User(0, name, pwd);
				User user2 = userServiceImpl.getUser(user);
				if (user2 != null && user.equals(user2)) {
					session.setAttribute("user", user);
					resp.sendRedirect(req.getContextPath() + "/Manager/Index.jsp");
				} else {
					resp.sendRedirect("Manager/Login.jsp?msg=0");
				}
			} else {
				resp.getWriter().append("用户名或密码不能为空");
			}
			break;
		case 3:

			break;

		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
