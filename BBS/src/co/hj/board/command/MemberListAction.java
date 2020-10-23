package co.hj.board.command;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Action;
import co.hj.board.dao.MemberDAO;
import co.hj.board.vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원리스트 보기 구현
		MemberDAO dao=new MemberDAO();
		//MemberVO vo=new MemberVO();
		List<MemberVO> list=new ArrayList<>();//결과받기위해서
		list=dao.selectAll();
		request.setAttribute("members",list); //members는 jsp에서 사용
		return "jsp/member/memberList.jsp";
	}

}
