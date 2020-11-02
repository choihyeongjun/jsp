package co.hj.board.command;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Action;
import co.hj.board.common.Paging;
import co.hj.board.dao.MemberDAO;
import co.hj.board.vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원리스트 보기 구현
		MemberDAO dao=new MemberDAO();
		//MemberVO vo=new MemberVO();
		List<MemberVO> list=new ArrayList<>();//결과받기위해서
		//페이지 번호 파라미터
		String strp=request.getParameter("p");
		
		//페이지번호가 없으면 1로 초기화
		int p=1;
		if(strp!=null && ! strp.equals("")) {
			p=Integer.parseInt(strp);
		}
		//레코드 건수조회
		Paging paging=new Paging();
		paging.setPageUnit(2);//페이지 출력건수 2페이지씩
		paging.setPageSize(3); //페이지번호수
		paging.setEndPage(p);
		MemberDAO cntdao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		paging.setTotalRecord(cntdao.count(vo));
		//목록 결과와 페이징 객체를 저장
		request.setAttribute("paging",paging);
		//해당페이지 리스트만 조회
		list=dao.selectAll(vo);		
		request.setAttribute("members",list); //members는 jsp에서 사용
		return "jsp/member/memberList.jsp";
	}

}
