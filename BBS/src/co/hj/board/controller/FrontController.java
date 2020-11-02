package co.hj.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.command.LoginAction;
import co.hj.board.command.LoginForm;
import co.hj.board.command.LogoutAction;
import co.hj.board.command.MainAction;
import co.hj.board.command.MemberForm;
import co.hj.board.command.MemberInsertAction;
import co.hj.board.command.MemberListAction;
import co.hj.board.common.Action;



@WebServlet("*.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2 // size of any uploaded file
				, maxRequestSize = 1024 * 1024 * 10 // overall size of all uploaded files
				, fileSizeThreshold = 1024)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String,Action>map =new HashMap<>();
    
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// 요청들을 정의함
		map.put("/main.do",new MainAction());//처음 들어오는 페이지 처리index.jsp
		map.put("/login.do",new LoginAction());//로그인 메뉴를 처리하는것
		map.put("/loginForm.do",new LoginForm());
		map.put("/memberList.do",new MemberListAction());//회원전체리스트 출력
		map.put("/memberForm.do",new MemberForm());//회원가입화면 호출
		map.put("/memberInsert.do",new MemberInsertAction());
		map.put("/logout.do",new LogoutAction());
//		map.put("/loginForm.do",new LoginForm());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수행할 명령을 정리
		request.setCharacterEncoding("UTF-8");//한글처리
		
		String uri=request.getRequestURI();
		String contextPath=request.getContextPath();
		String path=uri.substring(contextPath.length());//실제들어오는 요청페이지 찾음 substring 짜른뒤에서부터 값 시작
		Action command=map.get(path);
		String viewPage=command.exec(request, response);//명령이 수행되고 나서 보여줄 페이지 선택
		

		RequestDispatcher dispatcher =request.getRequestDispatcher(viewPage); //선택한 페이지로 가기
		dispatcher.forward(request, response);
	}

}
