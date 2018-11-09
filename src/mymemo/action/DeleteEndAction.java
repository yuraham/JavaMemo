package mymemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymemo.MemoDao;
//import mymemo.MemoInfo;
import mymemo.controller.CommandAction;

public class DeleteEndAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		MemoInfo memo = new MemoInfo();
		MemoDao data = new MemoDao();
		String idx = request.getParameter("idx");
		int midx = Integer.parseInt(idx);
		
		data.deletePost(midx);

		return "home.do";
	}
}
