package co.micol.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String msq;
		if(id.equals("hong"))
		{
			msq="홍길동님 환영합니다";
		}else {
			msq=id.toString()+"님 환영합니다";
		//	msq="등록된 회원이 아닙니다.";
		}
			
		
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<body>");
		out.print("<p> First Servlet Program!!!!!</p>");
		out.print("<p> Java :20201020 project !!!!!</p>");
		out.print("<p> 아이디: "+id+"</p>");
		out.print("<p> 비밀번호: "+pw+"</p>");
		out.print("<p>: "+msq+"</p>");
		
		out.print("</body>");
		out.print("</head>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
