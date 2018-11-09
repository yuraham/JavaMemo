package mymemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymemo.MemoDao;
import mymemo.MemoInfo;
import mymemo.controller.CommandAction;

public class DetailAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MemoInfo memo = new MemoInfo();
		MemoDao data = new MemoDao();
		String text = null;
		String idx = request.getParameter("idx");
		int midx = Integer.parseInt(idx);
		memo = data.detailPost(midx);
		
		if(memo == null) {
			text = "Fail: idx = " + midx;
			return "index.jsp";
		} else {
			text = midx+"번글";
		}
		
		request.setAttribute("memo", memo);
		request.setAttribute("text", text);
		
		return "detail.jsp";
	}
}
