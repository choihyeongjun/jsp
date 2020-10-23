package co.hj.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Action;

public class LoginForm implements Action {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "jsp/main/loginForm.jsp";
	}
}
