package city;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";
	
	// Constructor : JDBC 드라이버를 로딩 & DB Connection 구하기
	public CityDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// selectCondition
	public List<CityDTO> selectCondition(String query) {
		PreparedStatement pStmt = null;
		List<CityDTO> cityList = new ArrayList<CityDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				CityDTO city = new CityDTO();
				city.setId(rs.getInt(1)); 
				city.setName(rs.getString(2)); 
				city.setCountryCode(rs.getString(3)); 
				city.setDistrict(rs.getString(4)); 
				city.setPopulation(rs.getInt(5));

				cityList.add(city);
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
		return cityList;
	}

	// select - 조회 
	public List<CityDTO> selectAll() {
		String sql ="select * from city where Population >= 1000000 and CountryCode = 'KOR' order by Population desc;";
		List<CityDTO> cityList = selectCondition(sql);
		return cityList;
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
