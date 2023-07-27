package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeesDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/employee?useUnicode=true&characterEncoding=utf8";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public List<Employee> findAll(){
		List<Employee> empList=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try(Connection conn=DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){

			//
			String sql="SELECT ID,NAME,AGE FROM EMPLOYEES";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				
				Employee employee=new Employee(id,name,age);
				empList.add(employee);
			}
		}catch(SQLException e){
			return null;
		}
		return empList;
	}
	
	public boolean remove(int id) {
		boolean result=true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="DELETE FROM EMPLOYEES WHERE ID =?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int changed=pstmt.executeUpdate();
			if(changed !=1) {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;
		
	}

}
