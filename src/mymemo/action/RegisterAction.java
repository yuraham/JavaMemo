package mymemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymemo.MemoDao;
import mymemo.MemoInfo;
import mymemo.controller.CommandAction;

public class RegisterAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");

		CommonAction util = new CommonAction();
		MemoInfo memo = util.mappingReqMemo(request);		
		MemoDao data = new MemoDao();
		
		data.insertPost(memo);

		return "home.do";
	}
}
