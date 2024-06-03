package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;

public class JobDAO {

	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addJobs(Jobs j) {

		boolean f = false;

		try {

			String query = "INSERT INTO jobs (title,description,category,status,location) values (?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, j.getTitle());
			pst.setString(2, j.getDescription());
			pst.setString(3, j.getCategory());
			pst.setString(4, j.getStatus());
			pst.setString(5, j.getLocation());

			int i = pst.executeUpdate();
			if (i > 0) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Jobs> getAllJobs() {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;

		try {

			String query = "select * from jobs order by id desc;";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Jobs getJobsById(int id) {

		Jobs j = null;

		try {

			String query = "select * from jobs where id=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return j;
	}

	public boolean UpdateJob(Jobs j) {
		boolean f = false;

		try {

			String query = "UPDATE jobs SET title=?,description=?,category=?,status=?,location=? where id=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, j.getTitle());
			pst.setString(2, j.getDescription());
			pst.setString(3, j.getCategory());
			pst.setString(4, j.getStatus());
			pst.setString(5, j.getLocation());
			pst.setInt(6, j.getId());

			int i = pst.executeUpdate();
			if (i > 0) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteJobs(int id) {
		boolean f = false;
		
		try {
			
			String query="delete from jobs where id=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, id);
			
			int i=pst.executeUpdate();
			if(i>0) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<Jobs> getAllJobsForUser() {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;

		try {

			String query = "select * from jobs where status=? order by id desc;";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, "Active");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Jobs> getJobsOrLocationAndCat(String category ,String location) {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;

		try {

			String query = "select * from jobs where category=? or location =? order by id desc;";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, category);
			pst.setString(2, location);
			ResultSet rs = pst.executeQuery();
		
	
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Jobs> getJobsAndLocationAndCat(String category ,String location) {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs j = null;

		try {

			String query = "select * from jobs where category=? and location =? order by id desc;";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, category);
			pst.setString(2, location);
			ResultSet rs = pst.executeQuery();
		
	
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	

}











		









