package co.hj.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.hj.board.common.Action;
import co.hj.board.dao.MemberDAO;
import co.hj.board.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto 로그인 인증과정처리
		MemberDAO dao=new MemberDAO();
		MemberVO vo =new MemberVO();
		HttpSession session=request.getSession();
		String msg;
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo=dao.select(vo);
		if(vo.getPassword().equals(request.getParameter("password"))) {
		session.setAttribute("id",vo.getId());//session에 id담기
		session.setAttribute("author",vo.getId());//session에 권한담기
		session.setAttribute("name",vo.getName());
		msg="정상적인 로그인";
		request.setAttribute("msg",msg);
		request.setAttribute("vo", vo);//멤버를 실어보냄
		}
		else
		{
			msg="패스워드 불일치";
			request.setAttribute("msg",msg);
		}
		
//		if(vo.getName()==null) {
//			request.setAttribute("msg", "존재하지 않는 ID 입니다.");
//		}
		
	
		return "jsp/main/loginResult.jsp";
	}

}
