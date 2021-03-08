package com.ltts.Main;

import java.sql.Connection;
import java.sql.Statement;
import com.ltts.DAO.TeamDao;
import com.ltts.connec.MyConnection;

public class PlayerDelete extends TeamDao {

   public  void deletePlayer(Integer id) throws Exception{
      String SQL = "delete from Player where id = "+id;
      Connection c= MyConnection.getConnection();
      Statement stmt = c.createStatement();
      stmt.executeUpdate(SQL);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }
   public  void deleteTeam(Integer id) throws Exception{
	      String SQL = "delete from Player where teamid = "+id;
	      String SQL1 = "delete from Team where teamid = "+id;
	      String Sql="SET FOREIGN_KEY_CHECKS=0";
	      String Sql1="SET FOREIGN_KEY_CHECKS=1";
	      Connection c= MyConnection.getConnection();
	      
	      Statement stmt = c.createStatement();
	      stmt.execute(Sql);
	      stmt.executeUpdate(SQL1);
	      stmt.executeUpdate(SQL);
	      stmt.execute(Sql1);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
}