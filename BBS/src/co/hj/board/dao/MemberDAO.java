package co.hj.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.hj.board.vo.MemberVO;

public class MemberDAO extends DAO {
	private PreparedStatement psmt;//sql명령문 실행
	
	private ResultSet rs; //결과를 받을떄
	private MemberVO vo;
	
	private final String SELECT_ALL =" select * from( select a.*,rownum rn  from("
			+ "SELECT * FROM MEMBER order by id"
			+ ")a)b  where rn between ? and ?";
	private final String SELECT="SELECT * FROM MEMBER WHERE ID=?";
	private final String INSERT="INSERT INTO MEMBER(ID,NAME,PASSWORD,ADDRESS,TEL,ENTERDATE,IMG)"
			+ " VALUES(?,?,?,?,?,?,?)";
	private final String UPDATE="UPDATE MEMBER SET NAME=?,PASSWORD=? ADDRESS=?, TEL=?  WHERE ID=?";
	private final String DELETE="DELETE FROM MEMBER WHERE ID=?";
	
	
	public List<MemberVO> selectAll(MemberVO mvo){
		List<MemberVO> list=new ArrayList<>();
		try {
			psmt=conn.prepareStatement(SELECT_ALL);
			psmt.setInt(1, mvo.getFirst());
			psmt.setInt(2, mvo.getLast());
			rs=psmt.executeQuery();                                                                                                                                                                                                                                 
				while(rs.next()) {
					vo=new MemberVO();
					vo.setId(rs.getString("id"));//데베안의필드네임 ""안
					vo.setName(rs.getString("name"));
					vo.setPassword(rs.getString("password"));
					vo.setAuthor(rs.getString("author"));
					vo.setAddress(rs.getString("address"));
					vo.setTel(rs.getString("tel"));
					vo.setEnterdate(rs.getDate("enterdate"));
					vo.setImg(rs.getString("img"));
					list.add(vo);
					
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();//db연결 끊어준다
		}
		return list;
	}
	public int count(MemberVO vo) {
		int cnt=0;
		try {
			String sql="select count(*) from member";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			rs.next();
			cnt=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public MemberVO select(MemberVO vo) {
		try {
			psmt=conn.prepareStatement(SELECT);
			psmt.setString(1, vo.getId());
			//psmt.setString(2, vo.getPassword());
			rs=psmt.executeQuery();
			if(rs.next()) {
		
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setAuthor(rs.getString("author"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	public int insert(MemberVO vo) {
		int n=0;
		try {
			psmt=conn.prepareStatement(INSERT);
			psmt.setString(1,vo.getId());
			psmt.setString(2,vo.getName());
			psmt.setString(3,vo.getPassword());
			psmt.setString(4,vo.getAddress());
			psmt.setString(5,vo.getTel());
			psmt.setDate(6,vo.getEnterdate());
			psmt.setString(7,vo.getImg());
			n=psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	public int update(MemberVO vo) {
		int n=0;
		
		try {
			psmt=conn.prepareStatement(UPDATE);
			psmt.setString(1,vo.getName());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3,vo.getAddress());
			psmt.setString(4,vo.getTel());
			psmt.setString(5,vo.getId());
			n=psmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(MemberVO vo) {
		int n=0;
		try {
			psmt=conn.prepareStatement(DELETE);
			psmt.setString(1, vo.getId());
			n=psmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs!=null)
				rs.close();
			if(psmt!=null)
				psmt.close();
			if(conn!=null)
				conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
