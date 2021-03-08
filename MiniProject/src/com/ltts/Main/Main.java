package com.ltts.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;

import com.ltts.TeamPlayer.Player;
import com.ltts.TeamPlayer.Team;
import com.ltts.DAO.*;
import com.ltts.DAO.PlayerDAO;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Your Choice"); 
		System.out.println("1. Insert Data"); 
		System.out.println("2. Search Data"); 
		System.out.println("3. Update Data"); 
		System.out.println("4. View all the Players"); 
		System.out.println("5. View Players"); 
		System.out.println("5. Delete Players"); 
		int n= Integer.parseInt(br.readLine());
		if(n==1)
		{
			System.out.println("Enter the Team Id: "); 
			int tid=Integer.parseInt(br.readLine());
			System.out.println("Enter the Team Name: ");
		    String tname=br.readLine();
		    System.out.println("Enter the Owner Name: ");
		    String towner=br.readLine();
		    System.out.println("Enter the Coach Name: ");
		    String tcoach=br.readLine();
		    Team t= new Team(tid,tname,towner,tcoach);
		    TeamDao td=new TeamDao();
		    td.insertTeam(t);
			


			System.out.println("Enter the Player Id: "); 
			int pid=Integer.parseInt(br.readLine());
			System.out.println("Enter the Player Name: ");
		    String pname=br.readLine();
			System.out.println("Enter the Date of Birth: ");
		    Date pdate=Date.valueOf(br.readLine());
		    System.out.println("Enter the Player Nationality: ");
		    String pnation=br.readLine();
		    System.out.println("Enter the Player Skills: ");
		    String pskills=br.readLine();
		    System.out.println("Enter the Player runs: ");
		    int pruns=Integer.parseInt(br.readLine());
		    System.out.println("Enter the Player Wickets: ");
		    int pwic=Integer.parseInt(br.readLine());
		    System.out.println("Enter the Player Number of Matches: ");
		    int pnum=Integer.parseInt(br.readLine());
		    System.out.println("Enter Player Team Id: ");
		    int pteam=Integer.parseInt(br.readLine());
		    
		    Player p=new Player(pid,pname,pdate,pnation,pskills,pruns,pwic,pnum,pteam);
		    PlayerDAO pd=new PlayerDAO();
		    pd.insertPlayer(p);
		}
		else if(n==2)
		{
			System.out.println("Enter the Player Name: "); 
			String name=br.readLine();
			PlayerDAO pd=new PlayerDAO();
		    pd.getAll(name);
		}
		else if(n==3)
		{
			System.out.println("Enter table to update:");
			System.out.println("1.Team 2.Player");
			int u=Integer.parseInt(br.readLine());
		    if(u==1)
		    {
		    	System.out.println("Enter Team ID: ");
		    	int id=Integer.parseInt(br.readLine());
		    	System.out.println("Enter new Team Name: ");
		    	String name=br.readLine();
				TeamDao pd=new TeamDao();
			    pd.updateTeam(id,name);
		    }
		    else if(u==2)		
		    {
		    	System.out.println("Enter Playet ID: ");
		    	int id=Integer.parseInt(br.readLine());
		    	System.out.println("Enter new Player Name: ");
		    	String name=br.readLine();
				PlayerDAO pd=new PlayerDAO();
			    pd.updatePlayer(id,name);
		    }
		}
		else if(n==4)
		{
			PlayerDAO pd=new PlayerDAO();
		    pd.showPlayer();
		}
		else if(n==5)
		{
			System.out.println("1. View Players based on Team");
			System.out.println("2. View Players based on Skills & Team");
			int v=Integer.parseInt(br.readLine());
			if(v==1)
			{
				System.out.println("Enter Team Name: ");
				String tname=br.readLine();
				TeamDao pd=new TeamDao();
			    pd.teamPlayer(tname);
			}
			else if(v==2)
			{
				System.out.println("Enter Team Name: ");
				String tname=br.readLine();
				System.out.println("Enter Team Skill: ");
				String tskill=br.readLine();
				TeamDao pd=new TeamDao();
			    pd.skillPlayer(tname,tskill);
			}

		}
		
		else if(n==6) {
	        int doyou;
	        System.out.println("Do you want to delete something or not...Press 1 for yes and 2 for no");
	        doyou=Integer.parseInt(br.readLine());
	        
	        if(doyou==1) {
	        int id;
	        
	        System.out.println("Press 1 for player ...Press 2 for team...");
	        int choice=Integer.parseInt(br.readLine());
	        
	        
	       
	        PlayerDelete tl=new PlayerDelete();
	       
	     
	        if(choice==1) {
	        	System.out.println("ENTER PLAYER ID TO DELETE");
	        id=Integer.parseInt(br.readLine());
	       tl.deletePlayer(id);
	        }
	        else {
	        	System.out.println("ENTER Team ID TO DELETE");
		        id=Integer.parseInt(br.readLine());
	        	tl.deleteTeam(id);
	        }
	
	        }
	        else {
	        	System.out.println("Thank you");
	        }
	 
		}


	}
}
