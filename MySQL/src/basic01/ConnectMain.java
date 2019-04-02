package basic01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 자바와 MySQL or ORACLE을 연결해서 사용할때 총 6가지 과정을 거치게 됩니다.
// 1. 드라이버 로딩 2. DB연결 3. 쿼리준비 4. 쿼리실행 5. 데이터 가져오기 6. 커넥션 닫기

public class ConnectMain {
    public static void main(String[] args) {
        // DB와 연결하기 위한 Connection 객체 
    	Connection conn = null;
        
        // Query를 실행하기 위한 Statement 객체 
        Statement st = null;
        try {
        	// DataBase와 연결
        	// Class.forName으로 JDBC 드라이버를 로딩 
        	// 이 부분은 ClassNotFoundException 예외처리를 해주어야 하므로 try-catch문으로 감싸주어야 합니다.
            Class.forName("com.mysql.jdbc.Driver");	
            
            // DriverManager.getConnection로 DB Connection 구하기(즉, 어떤 DB를 사용할 건지 저장)
            // 이 부분은 SQLException 예외처리를 해주어야 하므로 try-catch로 감싸 주어야 합니다.
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false",
                "javauser", "javapass");	
            
// DELETE 
            String quertDelete = "delete from song where _id=?;"; // delete query
            
// INSERT
            // INSERT - value는 ?(물음표)로 설정 
            String query = "insert into song (title, lyrics) values (?, ?);"; // insert query
            
            // create the MySQL insert preparedStatement
            // INSERT는 값을 추가(설정)하는 것이므로 setString(int)로 넣어준다.
            // Statement가 PreparedStatement보다 상위 클래스이며 이 둘의 차이는
            // PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있다는 것이다.
            // 즉, 쿼리 문에 ?를 사용할 것이면 PreparedStatement사용 
            PreparedStatement pStmt = conn.prepareStatement(query);
            pStmt.setString(1, "가시나");
            pStmt.setString(2, "선미");
            
            // execute the preparedStatement
            // Query 실행을 담당합니다.(Query 실행 구문=pStmt.executeUpdate();)
            //pStmt.executeUpdate();
            
// UPDATE 
            String queryUpdate = "update song set lyrics=? where _id=?"; // update query
            PreparedStatement pStmtUpdate = conn.prepareStatement(queryUpdate);
            pStmtUpdate.setString(1, "왜 예쁜 날 두고 가시나");
            pStmtUpdate.setInt(2, 117);
            //pStmtUpdate.executeUpdate();
            
// SELECT 
            // st에 SQL문 저장 				
            st = conn.createStatement(); 
            
            String sql = "select id, date_format(datetime, '%Y-%m-%d %r') FROM date_table;"; // select query
            String sql1 = "select * FROM song where title like 'Gee';"; 
            
            // Query 실행 후 값을 가져오는 코드 (st.executeQuery(sql) or pStmt.executeQuery();)
            // PreparedStatement로 사용할때는 executeQuery()괄호안에 sql을 빼야 합니다.
            // 그 이유는 위 Update구문에서 보듯이 conn.prepareStatement(sql)방식으로 
            // sql이 PreparedStatement 객체에 저장되었기 때문입니다.
            // java.sql.ResultSet을 이용해서 쿼리실행 한 것을 ResultSet으로 받아들인다.
            ResultSet rs = st.executeQuery(sql1);
            
            // rs.next()로 한 줄씩 읽어오기, while문 혹은 if문으로 rs.next()가 null인지 확인하면서 돌린다.
            while (rs.next()) {
            	// SELECT는 검색을 하여 값을 출력하는 것이므로 getString(int)로 가져온다.
            	// DB는 인덱스가 1번부터 시작
                int id = rs.getInt(1); 
                String title = rs.getString(2);
                String lyrics = rs.getString(3);
                System.out.printf("%8d %-20s\t%s\n", id, title, lyrics);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        	// Connection Close(커넥션 닫기)
        	// 커넥션을 닫을때는 사용한 순서(Open한 순서) 반대의 순으로 닫아야 합니다.
        	// 가장 마직에 오픈한 rs.close()를 위에서 먼저 닫아주고 다음은 st, 마지막으로 처음에 선언한 conn
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se2) { }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}