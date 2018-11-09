package mymemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymemo.MemoDao;
import mymemo.MemoInfo;
import mymemo.controller.CommandAction;

public class UpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		CommonAction util = new CommonAction();
		MemoInfo memo = util.mappingReqMemo(request);
		MemoDao data = new MemoDao();
		
		String text ="";
		String idx = request.getParameter("idx");
		int midx = Integer.parseInt(idx);
		
		if (data.isPost(midx)) {
			data.updateMemo(memo, midx);
			text = "게시글 수정에 성공하였습니다.";
		} else {
			text = "게시글을 찾을 수 없습니다.";
			response.sendRedirect(request.getContextPath()+"/home.do");
			return null;
		}
		request.setAttribute("text", text);
		request.setAttribute("memo", memo);

		return "detail.do";
	}
	
}
