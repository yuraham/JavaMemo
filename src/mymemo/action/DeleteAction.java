package mymemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymemo.MemoDao;
import mymemo.MemoInfo;
import mymemo.controller.CommandAction;

public class DeleteAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		MemoInfo memo = new MemoInfo();
		MemoDao data = new MemoDao();
		String idx = request.getParameter("idx");
		int midx = Integer.parseInt(idx);
		
		memo=data.detailPost(midx);
		request.setAttribute("memo", memo);
		
		return "delete.jsp";
	}
}
