package mymemo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymemo.MemoDao;
import mymemo.MemoInfo;
import mymemo.controller.CommandAction;

public class HomeAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MemoDao memo = new MemoDao();
		
		String text= null;
		int num=memo.selectCount();
		List<MemoInfo> list = memo.allPost();
		
		if(list == null) {
			text = "등록된 글이 없습니다.";
		} else {
			text = "총 게시글 "+num;
		}
		
		request.setAttribute("num", num);
		request.setAttribute("list", list);
		request.setAttribute("text", text);

		return "index.jsp";
	}
}
