package ch16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class PollMgr {
	private DBConnectionMgr pool;
	
	public PollMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Max num : 가장 최신의 num값 리턴
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int maxNum = 0;
		try {
			con = pool.getConnection();
			sql = "select max(num) from tblpollList";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) maxNum = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return maxNum;
	}
	
	//Poll Insert : 설문과 아이템이 같이 저장
	public boolean insertPoll(PollListBean plBean, PollItemBean piBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert tblPollList(question,sdate,edate,wdate,type)"
					+ "values(?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, plBean.getQuestion());
			pstmt.setString(2, plBean.getSdate());
			pstmt.setString(3, plBean.getEdate());
			pstmt.setInt(4, plBean.getType());
			int cnt = pstmt.executeUpdate();
			pstmt.close();
			if(cnt==1) { //정상적인 tblPoll 저장
				sql = "insert tblPollItem values(?,?,?,0)";
				pstmt = con.prepareStatement(sql);
				int listNum = getMaxNum(); // 방금 저장한 리스트의 num값
				String item[] = piBean.getItem();
				for (int i = 0; i < item.length; i++) {
					if(item[i]==null||item[i].trim().equals(""))
						break;
					pstmt.setInt(1, listNum);
					pstmt.setInt(2, i);
					pstmt.setString(3, item[i]);
					if(pstmt.executeUpdate()==1)
						flag = true;
				}//--for
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//Poll List
	public Vector<PollListBean> getPollList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<PollListBean> vlist = new Vector<PollListBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblPollList order by num desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PollListBean plBean = new PollListBean();
				plBean.setNum(rs.getInt("num"));
				plBean.setQuestion(rs.getString("question"));
				plBean.setSdate(rs.getString("sdate"));
				plBean.setEdate(rs.getString("edate"));
				vlist.addElement(plBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//Poll Read
	public PollListBean getPoll(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PollListBean plBean = new PollListBean();
		try {
			con = pool.getConnection();
			sql = "select num, question, type, active from tblPollList where num = ?";
			pstmt = con.prepareStatement(sql);
			if(num==0)
				num = getMaxNum();
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				plBean.setNum(rs.getInt(1));
				plBean.setQuestion(rs.getString(2));
				plBean.setType(rs.getInt(3));
				plBean.setActive(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return plBean;
	}
	
	//Poll Item List
	public Vector<String> getItemList(int listNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<String> vlist = new Vector<String>();
		try {
			con = pool.getConnection();
			sql = "select item from tblpollItem where listNum = ?";
			pstmt = con.prepareStatement(sql);
			if(listNum==0)
				listNum = getMaxNum();
			pstmt.setInt(1, listNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vlist.addElement(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//Count Sum : 설문 투표 수
	
	//Poll Update : 투표 실행
	
	//Poll View : 결과 보기
	
	//Max Item Count : 아이템 중에 가장 높은 투표값
}
