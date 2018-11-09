package mymemo.controller;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<>();
	
	public void init(ServletConfig config) throws ServletException {
		loadProperties("mymemo.properties/Command");
	}
	
	//properties설정
    private void loadProperties(String path) {
        ResourceBundle rbHome = ResourceBundle.getBundle(path);// 누구를 실행할지를 rb에 저장
        Enumeration<String> actionEnumHome = rbHome.getKeys();
        while (actionEnumHome.hasMoreElements()) {
            String command = actionEnumHome.nextElement();
            String className = rbHome.getString(command);
            try {
                Class commandClass = Class.forName(className); // 해당 문자열을 클래스로
                Object commandInstance = commandClass.newInstance(); // 해당 클래스의 객체를 생성
                commandMap.put(command, commandInstance); // Map 객체인 commandMap에 객체 저장
            } catch (ClassNotFoundException e) {
                continue; // error throw new ServletException(e);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
	
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestProperty(request, response); // get방식과 post방식을 모두 requestPro로 처리
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestProperty(request, response);
    }
	
    // 사용자의 요청을 분석해서 해당 작업을 처리
    private void requestProperty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String view = null;
        CommandAction com = null;
        try {
            String command = request.getRequestURI();
            if (command.indexOf(request.getContextPath()) == 0) {
                command = command.substring(request.getContextPath().length());
            }
            com = (CommandAction)commandMap.get(command);
            if (com == null) {
                System.out.println("not found : " + command);
                return;
            }
            view = com.requestPro(request, response);
            if (view == null) {
                return;
            }
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
	}
}
