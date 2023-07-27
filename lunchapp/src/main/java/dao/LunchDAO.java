package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Lunch;

public class LunchDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() throws NamingException, SQLException{
		Context context=new InitialContext();
		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/jsp");
		this.db=ds.getConnection();
	}

	private void disconnect() {
		try {
			if(rs !=null){
			rs.close();
			}
			if(ps !=null){
			ps.close();
			}
			if(db !=null){
			db.close();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public List<Lunch> findAll(){
		List<Lunch> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM lunches");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String menu=rs.getString("menu");
				Lunch l=new Lunch(id,name,menu);
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
		
		
		
		
	}
	
	
}
