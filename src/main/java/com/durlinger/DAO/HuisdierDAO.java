package com.durlinger.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.durlinger.Huisdier;

// In eerste instantie deze class gemaakt. Verkenning/herhaling van jdbc. 
//Uiteindelijk CRUDrepostitoryinterface gebruikt van Java Springboot.


public class HuisdierDAO 
{
	Connection con = null;
	public HuisdierDAO()
	{
		
		String url = "jdbc:postgresql://localhost:5432/Huisdieren";
		String username = "postgres";
		String password = "kerstmis2020";
		 try 
		  { 
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, username,password);
		  }
		  
		  catch(Exception e) 
		  { 
			  System.out.println(e); 
		  }
	}
	
	public Huisdier getHuisdier(String naam)
	{
		String sql = "select * from Huisdiertjes where naam=" + naam; 
		Huisdier h1 = new Huisdier();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next());
			{
				h1.setNaam(rs.getString("naam"));
				h1.setLeeftijd(rs.getInt("leeftijd"));
				h1.setDiersoort(rs.getString("diersoort"));
			}
		}
		catch(Exception e) 
		{ 
			System.out.println(e); 
		}

		return h1;
	}
	
	
		
		public List<Huisdier> getHuisdieren()
		{
			List<Huisdier> huisdieren = new ArrayList<>();	
			String sql = "select * from Huisdiertjes";
			
			try
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					Huisdier h = new Huisdier();
					h.setNaam(rs.getString(1));
					h.setLeeftijd(rs.getInt(2));
					h.setDiersoort(rs.getString(3));
					
					huisdieren.add(h);
				}
			} 
			catch(Exception e) 
			{ 
				System.out.println(e); 
			}
			
			return huisdieren;
			
		}
		
		public void createHuisdier(Huisdier h1)
		{
			String sql = "instert into Huisdiertjes values(?,?,?)"; 
		
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, h1.getNaam());
				st.setInt(2, h1.getLeeftijd()); 
				st.setString(3, h1.getDiersoort());
				st.executeUpdate();
			}
			catch(Exception e) 
			{ 
				System.out.println(e); 
			}
		}
		
		public void updateHuisdier(Huisdier h1)
		{
			String sql = "update Huisdiertjes set , Diersoort=? Leeftijd=?, where naam=?"; 
		
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, h1.getNaam());
				st.setInt(2, h1.getLeeftijd()); 	
				st.setString(3, h1.getDiersoort());
				st.executeUpdate();
			}
			catch(Exception e) 
			{ 
				System.out.println(e); 
			}
		}
		
		
		public void deleteHuisdier(String naam)
		
		{
			String sql = "delete from Huisdiertjes where naam=?"; 
		
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, naam);
				st.executeUpdate();
			}
			catch(Exception e) 
			{ 
				System.out.println(e); 
			}
		}
		
	}

