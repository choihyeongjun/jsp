package co.hj.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Action;
import co.hj.board.dao.MemberDAO;
import co.hj.board.vo.MemberVO;

public class MemberInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//회원정보를 db에 입력하기
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setEnterdate(Date.valueOf(request.getParameter("enterdate")));
		int n=dao.insert(vo);
		request.setAttribute("check", n);
		String page;
		if(n!=0) {
			page="jsp/member/insertSuccess.jsp";
		}
		else
		{
			page="jsp/member/InsertFail.jsp";
		}
		return page;
	}

}
