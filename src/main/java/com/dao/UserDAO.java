package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User u) {
		boolean f = false;
		try {

			String query = "Insert into user (name,email,password,qualification,role) VALUES (?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getQualification());
			pst.setString(5, "user");

			int i = pst.executeUpdate();
			if (i > 0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String email, String password) {
		User u = null;

		try {
			String query = "Select * from user where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setQualification(rs.getString(5));
				u.setRole(rs.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public boolean updateUser(User u) {
		boolean f = false;

		try {
			String query = "UPDATE user SET name=? , qualification=?,email=? ,password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, u.getName());
			pst.setString(2, u.getQualification());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPassword());
			pst.setInt(5, u.getId());

			int i = pst.executeUpdate();
			if (i > 0) {
				f = true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
