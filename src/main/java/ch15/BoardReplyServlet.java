package ch15;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardReplyServlet
 */
@WebServlet("/ch15/boardReply")
public class BoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardMgr mgr = new BoardMgr();
		BoardBean reBean = new BoardBean();
		reBean.setName(request.getParameter("name"));
		reBean.setSubject(request.getParameter("subject"));
		reBean.setContent(request.getParameter("content"));
		reBean.setRef(UtilMgr.parseInt(request,"ref"));
		reBean.setPos(UtilMgr.parseInt(request,"pos"));
		reBean.setDepth(UtilMgr.parseInt(request,"depth"));
		reBean.setPass(request.getParameter("pass"));
		reBean.setIp(request.getParameter("ip"));
		
		mgr.replyUpBoard(reBean.getRef(),reBean.getPos());
		mgr.replyBoard(reBean);
		
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		response.sendRedirect("list.jsp?nowPage="+nowPage+
				"&numPerPage="+numPerPage);
	}

}
