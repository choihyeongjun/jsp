package co.hj.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Action;

public class MemberForm implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 폼 호출
		return "jsp/member/memberForm.jsp";
	}

}
