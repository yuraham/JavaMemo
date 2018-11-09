package mymemo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemoDao extends CommonDao {
	
	//개수를 얻는 메서드
	public int selectCount() {
		Statement stmt = null;
		String query = "SELECT * FROM memo";
		int count=0;
		openConnection();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return count;
	}
	
	//모든 레코드 가져오기
	public List<MemoInfo> allPost() {
		List<MemoInfo> list = null;
		Statement stmt = null;
		String query = "SELECT idx, name, content, regdate FROM memo";
		openConnection();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					MemoInfo memo = new MemoInfo();
					memo.setIdx(rs.getInt("idx"));
					memo.setName(rs.getString("name"));
					memo.setContent(rs.getString("content"));
					memo.setRegdate(rs.getTimestamp("regdate"));
					list.add(memo);
				} while(rs.next());
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return list;
	}
	
	public MemoInfo detailPost(int idx) {
		PreparedStatement pstmt = null;
		MemoInfo memo = new MemoInfo();
		String query = "SELECT * FROM memo WHERE idx=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			memo.setIdx(rs.getInt("idx"));
			memo.setName(rs.getString("name"));
			memo.setContent(rs.getString("content"));
			memo.setRegdate(rs.getTimestamp("regdate"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return memo;
	}
	
	public int insertPost(MemoInfo memo) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO memo VALUES(null,?,?,?,now())";
		int res=0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memo.getName());
			pstmt.setString(2, memo.getPass());
			pstmt.setString(3, memo.getContent());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	public boolean isPost(int idx) {
		PreparedStatement pstmt=null;
		String query="SELECT * FROM memo WHERE idx=?";
		boolean res = false;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			res = rs.next();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	public int updateMemo(MemoInfo memo, int idx) {
		PreparedStatement pstmt = null;
		String query = "UPDATE memo SET content=? WHERE idx=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memo.getContent());
			pstmt.setInt(2, idx);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
	public int deletePost(int idx) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM memo WHERE idx=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}
	
}