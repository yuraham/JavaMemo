package mymemo.action;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import mymemo.MemoInfo;

public class CommonAction {
	public MemoInfo mappingReqMemo(HttpServletRequest request) throws Throwable {
		MemoInfo memo = new MemoInfo();
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String paramName = (String)parameterNames.nextElement();
			switch(paramName) {
			case "name":
				memo.setName(request.getParameter("name"));
				break;
			case "pass":
				memo.setPass(request.getParameter("pass"));
				break;
			case "content":
				memo.setContent(request.getParameter("content"));
				break;
			}
		}
		return memo;
	}
}
