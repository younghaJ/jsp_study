package ch09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class TeamMgr {

	private DBConnectionMgr pool;
	
	public TeamMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//리스트
	
	public Vector<TeamBean> listTeam(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<TeamBean> vlist = new Vector<TeamBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblTeam";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TeamBean bean = new TeamBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setCity(rs.getString("city"));
				bean.setAge(rs.getInt("age"));
				bean.setTeam(rs.getString("team"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//저장
	public void insertTeam(TeamBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
//			sql = "insert tblteam values(null,?,?,?,?)";
			sql = "insert tblteam(name,city,age,team)" + "values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getCity());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getTeam());
			// valuse('홍길동','부산',23,'산적'); 
			pstmt.executeUpdate();// SQL문 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	//한개의 레코드 가져오기
	public TeamBean getTeam(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		TeamBean bean = new TeamBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblTeam where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// where 절 이하에 조건이 pk 로 선언된 컬럼일때 if문으로 사용.
			if(rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setCity(rs.getString("city"));
				bean.setAge(rs.getInt("age"));
				bean.setTeam(rs.getString("team"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//수정
	public boolean updateTeam(TeamBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update tblTeam set name=?, city=?, age=?, team=? where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getCity());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getTeam());
			pstmt.setInt(5, bean.getNum());
			int cnt = pstmt.executeUpdate();// SQL문 실행
			if(cnt == 1)flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//삭제
	public void deleteTeam(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "delete from tblTeam where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	public Vector<String> teamList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<String> vlist = new Vector<String>();
		try {
			con = pool.getConnection();
			sql = "select distinct team from tblTeam";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vlist.addElement(rs.getString(1));
			}
//			System.out.println(vlist.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	public static void main(String[] args) {
		TeamMgr mgr = new TeamMgr();
		mgr.teamList();
	}
	
}
