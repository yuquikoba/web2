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

import model.Mutter;

public class MutterDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() throws NamingException, SQLException {
		Context context=new InitialContext();
		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/jsp");
		this.db=ds.getConnection();
	}
	
	private void disconnect() {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(ps !=null) {
				ps.close();
			}
			if(db !=null) {
				db.close();
			}
		} catch (SQLException e) {
	// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public List<Mutter> findAll(){
		List<Mutter> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM mutters ORDER BY id DESC");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String userName=rs.getString("username");
				String userText=rs.getString("usertext");
				list.add(new Mutter(id,userName,userText));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	
	public void insertOne(Mutter mutter) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO mutters(username,usertext) VALUES(?,?)");
			//一つ目の?
			ps.setString(1, mutter.getUserName());
			//二つ目の?
			ps.setString(2, mutter.getUserText());
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public Mutter findOne(int id) {
		Mutter mutter=null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM mutters WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String userText=rs.getString("userText");
				mutter=new Mutter(id,userText);
			}
			} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return mutter;
	}
	public void updateOne(Mutter mutter) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE mutters SET usertext=? WHERE id=?");
			ps.setString(1, mutter.getUserText());
			ps.setInt(2, mutter.getId());
			ps.executeUpdate();
			System.out.println(ps);
			
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM mutters WHERE id=?");
			ps.setInt(1, id);
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

}
