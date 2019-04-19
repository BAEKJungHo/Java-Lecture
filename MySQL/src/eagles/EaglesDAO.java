package eagles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basic02.SongDTO;

public class EaglesDAO {
	
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";
	

	// Constructor : JDBC 드라이버를 로딩 & DB Connection 구하기
	public EaglesDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// INSERT QUERY
	// 메인프로그램에서 매개변수를 new SongDTO(매개변수1 .....)로 주면된다.
	public void insertPlayer(EaglesDTO player) { 
		String query = "insert into eagles values (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, player.getBackNo());
			pStmt.setString(2, player.getName());
			pStmt.setString(3, player.getPosition());
			pStmt.setString(4, player.getHs());
			pStmt.setString(5, player.getHand());
			pStmt.setInt(6, player.getBirth());
			pStmt.setInt(7, player.getSalary());
			
			pStmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	// UPDATE QUERY : 트레이드할 번호를 매개변수로 추가로 줌
	public void updatePlayer(EaglesDTO player, int tradeNo) { 
		String query = "update eagles set no=?, name=?, position=?, highschool=?, throw_hand=?, birth=?, salary=? where no=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, player.getBackNo());
			pStmt.setString(2, player.getName());
			pStmt.setString(3, player.getPosition());
			pStmt.setString(4, player.getHs());
			pStmt.setString(5, player.getHand());
			pStmt.setInt(6, player.getBirth());
			pStmt.setInt(7, player.getSalary());
			pStmt.setInt(8, tradeNo);
			
			pStmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	// DELETE QUERY
	public void deletePlayer(int backno) { 
		String query = "delete from eagles where no=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, backno);
			
			pStmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	// selectOne
	// return 값 : 객체 
	public EaglesDTO selectOne(int backno) {
		String query = "select * from eagles where no=?;";
		PreparedStatement pStmt = null;
		EaglesDTO player = new EaglesDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1,  backno);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				player.setBackNo(rs.getInt(1)); 
				player.setName(rs.getString(2)); 
				player.setPosition(rs.getString(3)); 
				player.setHs(rs.getString(4)); 
				player.setHand(rs.getString(5));
				player.setBirth(rs.getInt(6)); 
				player.setSalary(rs.getInt(7)); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return player;
	}
	
	// selectAll
	public List<EaglesDTO> selectCondition(String query) {
		// String query = "select * from eagles;";
		PreparedStatement pStmt = null;
		List<EaglesDTO> playerList = new ArrayList<EaglesDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				EaglesDTO player = new EaglesDTO();
				player.setBackNo(rs.getInt(1)); 
				player.setName(rs.getString(2)); 
				player.setPosition(rs.getString(3)); 
				player.setHs(rs.getString(4)); 
				player.setHand(rs.getString(5));
				player.setBirth(rs.getInt(6)); 
				player.setSalary(rs.getInt(7)); 
				playerList.add(player);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return playerList;
	}
	
	// selectPlayers
	public List<EaglesDTO> selectPlayersBySalary(int salary) {
		String sql = "select * from eagles where salary >=" + salary + ";";
		List<EaglesDTO> playerList = selectCondition(sql);
		return playerList;
	}
	
	public List<EaglesDTO> selectPlayersByPosition(String position) {
		String sql ="select * from eagles where position like'" + position + "';";
		List<EaglesDTO> playerList = selectCondition(sql);
		return playerList;
	}
	
	public List<EaglesDTO> selectAll() {
		String sql ="select * from eagles;";
		List<EaglesDTO> playerList = selectCondition(sql);
		return playerList;
	}
	
	// Connection Close
	public void close() {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
