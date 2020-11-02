package co.hj.board.command;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.hj.board.common.Action;
import co.hj.board.common.FileRenamePolicy;
import co.hj.board.common.FileUtil;
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
	
		String appPath = request.getServletContext().getRealPath("/images");
		System.out.println(appPath);
				try {
					for (Part part : request.getParts()) { //첨부파일을 읽어온다
					     String fileName = FileUtil.extractFileName(part); //파일이 존재하면
					     if(!fileName.equals("")) {
					    	 //파일명중복체크
					        String uploadFile = appPath + File.separator + fileName;
					        File renameFile=FileRenamePolicy.rename(new File(uploadFile));
					       
								part.write(renameFile.getAbsolutePath());
					        vo.setImg(renameFile.getName());
					        
					     
					        //1:다 관계로 등록 filetable.insert(filevo);
					     }
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	
		
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
