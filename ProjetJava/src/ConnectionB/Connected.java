package ConnectionB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.event.MenuListener;

import Agence.MenuInterface;

public class Connected 
{
	
	public static Connection ConnexionMethode() throws Exception
	
	{
		
	
		if(MenuInterface.SERVERNAME.equals("")) {
			JOptionPane.showMessageDialog(null,"le server name n'est pas reconue","Message information",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		 //String connectionUrl = "jdbc:sqlserver://HP-PC;database=GestionImmobiliére;integratedSecurity=true;";
		 String connectionUrl = "jdbc:sqlserver://"+MenuInterface.SERVERNAME+";database=GestionImmobiliére;integratedSecurity=true;";
         //le premier url de Connection necessite le nom du serveur que vous travailler avec pour mon cas c'est HP-PC
	     Connection conn = DriverManager.getConnection(connectionUrl);
	   	 return conn;
	}
	

}
