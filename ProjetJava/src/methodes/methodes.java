package methodes;
import ConnectionB.Connected;

import java.sql.*;

import java.util.ArrayList;

public class methodes {
	
	
	

	public static ArrayList<villa> liste_des_villas() throws Exception 
	{
		ArrayList<villa> a=new ArrayList<villa>();
		Connection conn = Connected.ConnexionMethode();
		
		CallableStatement cst = conn.prepareCall("{call dbo.afficherVilla}");
		ResultSet rs=cst.executeQuery();
	
		while(rs.next()) 
		{
			a.add(new villa(rs.getInt(1), rs.getDouble(2),rs.getString(10) , rs.getString(3),rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9)));
		}
		
		return a;
	}
	
	
	
	
	public static ArrayList<maison> liste_des_maisons() throws Exception
	{
		ArrayList<maison> a=new ArrayList<maison>();
        Connection conn = Connected.ConnexionMethode();
		CallableStatement cst = conn.prepareCall("{call dbo.afficherMaison}");
		ResultSet rs=cst.executeQuery();

		while(rs.next()) 
		{
			a.add(new maison(rs.getInt(1),rs.getDouble(2),rs.getString(10),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
		}
		
		return a;
	}
	
	
	public static ArrayList<appartement> liste_des_appartements() throws Exception 
	{
		ArrayList<appartement> a=new ArrayList<appartement>();
		Connection conn = Connected.ConnexionMethode();
		CallableStatement cst = conn.prepareCall("{call dbo.afficherAppartement}");
		ResultSet rs=cst.executeQuery();

		while(rs.next()) 
		{
			a.add(new appartement(rs.getInt(1),rs.getDouble(3),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(10),rs.getInt(7),rs.getInt(9),rs.getInt(8)));
		}
		
		return a;
	}
	
	
	public static ArrayList<terrain> liste_des_terrains() throws Exception{
		ArrayList<terrain> a=new ArrayList<terrain>();
		Connection conn = Connected.ConnexionMethode();
		CallableStatement cst = conn.prepareCall("{call dbo.afficherTerrain}");
		ResultSet rs=cst.executeQuery();

		while(rs.next()) 
		{
			a.add(new terrain(rs.getInt(1),(float) rs.getDouble(2),rs.getString(4),rs.getString(6),rs.getString(3),rs.getString(5)));
		}

		
		
		return a;
	}
	/**********************************************par ville*****************************************/
	
	
	
	
	public static ArrayList<villa> liste_des_villas_par_ville(String s) throws Exception
	{
		ArrayList<villa> a=new ArrayList<villa>();
		Connection conn = Connected.ConnexionMethode();
		CallableStatement cst = conn.prepareCall("{call dbo.afficherVilla_par_Ville(?)}");
		cst.setString(1, s);
		ResultSet rs=cst.executeQuery();
		
		while(rs.next()) {
			
			a.add(new villa(rs.getInt(1), rs.getDouble(2),rs.getString(10) , rs.getString(3),rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9)));

		}

		
		return a;
	}
	
	public static ArrayList<maison> liste_des_maisons_par_ville(String s) throws Exception{
		ArrayList<maison> a=new ArrayList<maison>();
		
		 Connection conn = Connected.ConnexionMethode();
			CallableStatement cst = conn.prepareCall("{call dbo.Recherche_Maison_Par_Villee(?)}");
			cst.setString(1, s);
			ResultSet rs=cst.executeQuery();

			while(rs.next()) 
			{
				a.add(new maison(rs.getInt(1),rs.getDouble(2),rs.getString(10),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
			}
			
		
		return a;
	}
	
	public static ArrayList<appartement> liste_des_appartements_par_ville(String s) throws Exception{
		ArrayList<appartement> a=new ArrayList<appartement>();
		Connection conn = Connected.ConnexionMethode();
		CallableStatement cst = conn.prepareCall("{call dbo.afficherAppartement_par_Ville(?)}");
		cst.setString(1, s);
		ResultSet rs=cst.executeQuery();

		while(rs.next()) 
		{
			a.add(new appartement(rs.getInt(1),rs.getDouble(3),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(10),rs.getInt(7),rs.getInt(9),rs.getInt(8)));
		}
		return a;
	}
	
	public static ArrayList<terrain> liste_des_terrains_par_ville(String s) throws Exception{
		ArrayList<terrain> a=new ArrayList<terrain>();
		Connection conn = Connected.ConnexionMethode();
		CallableStatement cst = conn.prepareCall("{call dbo.Recherche_Terain_Par_Ville(?)}");
		cst.setString(1, s);
		ResultSet rs=cst.executeQuery();

		while(rs.next()) 
		{
			a.add(new terrain(rs.getInt(1),(float) rs.getDouble(2),rs.getString(4),rs.getString(6),rs.getString(3),rs.getString(5)));
		}

		return a;
	}
	
	
	
	/********************par prix
	 * @throws Exception ********************************************/
	
	public static ArrayList<villa> liste_des_villas_par_prix(double x,double y) throws Exception {
		ArrayList<villa> a=new ArrayList<villa>();
		Connection conn=Connected.ConnexionMethode();
		CallableStatement stm=conn.prepareCall("{call dbo.afficherVilla_par_prix(?,?)}");
		stm.setDouble(1, x);
		stm.setDouble(2, y);
		ResultSet rs=stm.executeQuery();
		
		while(rs.next()) {
			
			a.add(new villa(rs.getInt(1), rs.getDouble(2),rs.getString(10) , rs.getString(3),rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9)));

		}
		
		
		return a;
	}
	
	public static ArrayList<maison> liste_des_maisons_par_prix(double x,double y) throws Exception{
		ArrayList<maison> a=new ArrayList<maison>();
		
		Connection conn=Connected.ConnexionMethode();
		CallableStatement stmt=conn.prepareCall("{call dbo.afficherMaison_par_prix(?,?)}");
		stmt.setDouble(1, x);
		stmt.setDouble(2, y);
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()) 
		{
			a.add(new maison(rs.getInt(1),rs.getDouble(2),rs.getString(10),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
		}
		
		
		return a;
	}
	
	public static ArrayList<appartement> liste_des_appartements_par_prix(double x,double y) throws Exception {
		ArrayList<appartement> a=new ArrayList<appartement>();
		
		Connection conn=Connected.ConnexionMethode();
		CallableStatement stmt=conn.prepareCall("{call dbo.afficherAppartement_par_prix(?,?)}");
		stmt.setDouble(1, x);
		stmt.setDouble(2, y);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) 
		{
			a.add(new appartement(rs.getInt(1),rs.getDouble(3),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(10),rs.getInt(7),rs.getInt(9),rs.getInt(8)));
		}
		
		return a;
	}
	
	public static ArrayList<terrain> liste_des_terrains_par_prix(double x,double y) throws Exception{
		ArrayList<terrain> a=new ArrayList<terrain>();
		
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stmt=conn.prepareCall("{call dbo.afficherTerrain_par_prix(?,?)}");
		stmt.setDouble(1, x);
		stmt.setDouble(2, y);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) 
		{
			a.add(new terrain(rs.getInt(1),(float) rs.getDouble(2),rs.getString(4),rs.getString(6),rs.getString(3),rs.getString(5)));
		}

		
		return a;
	}
	
	
	
	
	/********************************************personnalisees***********************************************************/
	public static ArrayList<villa> liste_des_villas_personnalisee(Double x,Double y,String s) throws Exception {
		ArrayList<villa> a=new ArrayList<villa>();
		Connection conn =Connected.ConnexionMethode();
		CallableStatement stm=conn.prepareCall("{call dbo.RECHERCHE_VILLA_PAR_PRIX_VILLE(?,?,?)}");
		stm.setDouble(1, x);
		stm.setDouble(2, y);
		stm.setString(3, s);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) {
			
			a.add(new villa(rs.getInt(1), rs.getDouble(2),rs.getString(10) , rs.getString(3),rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7), rs.getInt(8), rs.getInt(9)));

		}
		
		return a;
	}
	
	public static ArrayList<maison> liste_des_maisons_personnalisee(Double x,Double y,String s) throws Exception {
		ArrayList<maison> a=new ArrayList<maison>();
		Connection conn =Connected.ConnexionMethode();
		CallableStatement stm=conn.prepareCall("{call dbo.RECHERCHE_MAISON_PAR_PRIX_VILLE(?,?,?)}");
		stm.setDouble(1, x);
		stm.setDouble(2, y);
		stm.setString(3, s);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) 
		{
			a.add(new maison(rs.getInt(1),rs.getDouble(2),rs.getString(10),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
		}
		
		
		
		return a;
	}
	
	public static ArrayList<appartement> liste_des_appartements_personnalisee(Double x,Double y, String s) throws Exception{
		ArrayList<appartement> a=new ArrayList<appartement>();
		Connection conn =Connected.ConnexionMethode();
		
		CallableStatement stm=conn.prepareCall("{call dbo.RECHERCHE_Appartement_PAR_PRIX_VILLE(?,?,?)}");
		stm.setDouble(1, x);
		stm.setDouble(2, y);
		stm.setString(3, s);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) 
		{
			a.add(new appartement(rs.getInt(1),rs.getDouble(3),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(10),rs.getInt(7),rs.getInt(9),rs.getInt(8)));
		}
		
		return a;
	}
	
	public static ArrayList<terrain> liste_des_terrains_personnalisee(Double x,Double y, String s ) throws Exception{
		ArrayList<terrain> a=new ArrayList<terrain>();
		Connection conn =Connected.ConnexionMethode();

		CallableStatement stm=conn.prepareCall("{call dbo.RECHERCHE_Terain_PAR_PRIX_VILLE(?,?,?)}");
		stm.setDouble(1, x);
		stm.setDouble(2, y);
		stm.setString(3, s);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) 
		{
			a.add(new terrain(rs.getInt(1),(float) rs.getDouble(2),rs.getString(4),rs.getString(6),rs.getString(3),rs.getString(5)));
		}
		return a;
	}
	/*******************************************************admin******************************************************/
	
	/***********insertion**********/

	public static void inserer_dans_villa(double prix, String ville, String superficie,String adresse, int nbrechambres, int nbreetages, int nbrecuisines,
			int nbrebains, int nbretoilettes) throws Exception{
		
		Connection conn =Connected.ConnexionMethode();
      
		CallableStatement stm=conn.prepareCall("{call dbo.INSERT_VILLA(?,?,?,?,?,?,?,?,?)}");
		stm.setString(1, ville);
		stm.setDouble(2, prix);
		stm.setInt(3, Integer.valueOf(superficie));
		stm.setString(4, adresse);
		stm.setInt(5, nbrechambres);
		stm.setInt(6, nbretoilettes);
		stm.setInt(7, nbrecuisines);
		stm.setInt(8, nbrebains);
		stm.setInt(9, nbreetages);
		stm.executeUpdate();
	

	}
	
	public static void inserer_dans_maison(double prix, String ville, String superficie,String adresse, int nbrechambres, int nbreetages, int nbrecuisines,
			int nbrebains, int nbretoilettes) throws Exception{
		
		Connection conn =Connected.ConnexionMethode();
	
		CallableStatement stm=conn.prepareCall("{call dbo.INSERT_Maison(?,?,?,?,?,?,?,?,?)}");
		stm.setDouble(1, prix);
		stm.setString(2, ville);
		stm.setInt(3, Integer.valueOf(superficie));
		stm.setString(4, adresse);
		stm.setInt(5, nbrechambres);
		stm.setInt(6, nbretoilettes);
		stm.setInt(7, nbrecuisines);
		stm.setInt(8, nbrebains);
		stm.setInt(9, nbreetages);
		stm.executeUpdate();
	}

	public static void inserer_dans_appartement(double prix, String ville, String superficie,String adresse, int nbrechambres, int numeetage, int nbrecuisines,
			int nbrebains, int nbretoilettes) throws Exception{
		Connection conn =Connected.ConnexionMethode();
        
		CallableStatement stm =conn.prepareCall("{call dbo.INSERT_Appartement(?,?,?,?,?,?,?,?,?)}");
		stm.setDouble(1, prix);
		stm.setString(2, ville);
		stm.setInt(3, Integer.valueOf(superficie));
		stm.setString(4, adresse);
		stm.setInt(5, nbrechambres);
		stm.setInt(6, nbretoilettes);
		stm.setInt(7, nbrecuisines);
		stm.setInt(8, nbrebains);
		stm.setInt(9, numeetage);
		stm.executeUpdate();
		
	}
	
	public static void inserer_dans_terrain(float prix, String adresse, String ville, String superficie, String type) throws Exception{
		
		Connection conn=Connected.ConnexionMethode();
		CallableStatement stm=conn.prepareCall("{call dbo.INSERT_Terrain(?,?,?,?,?)}");
	
		stm.setDouble(1, prix);
		stm.setInt(2, Integer.valueOf(superficie));
		stm.setString(3, adresse);
		stm.setString(4, type);
		stm.setString(5, ville);
		
		stm.executeUpdate();
		
	}
	
	
	
	/************modification*******/
	
	public static void modifier_villa(int s,double prix, String ville, String superficie,String adresse, int nbrechambres, int nbreetages, int nbrecuisines,
			int nbrebains, int nbretoilettes) throws Exception{
		
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.ModifierVilla(?,?,?,?,?,?,?,?,?,?)}");

		stm.setDouble(1, prix);
        stm.setInt(2, Integer.valueOf(superficie));
        stm.setString(3, adresse);
        stm.setInt(4, nbrechambres);
        stm.setInt(5, nbreetages);
        stm.setInt(6, nbrecuisines);
        stm.setInt(7, nbrebains);
        stm.setInt(8, nbretoilettes);
        stm.setString(9, ville);
        stm.setInt(10, s);
        stm.executeUpdate();
		
	}
	
	
	public static void modifier_maison(int s,double prix, String ville, String superficie,String adresse, int nbrechambres, int nbreetages, int nbrecuisines,
			int nbrebains, int nbretoilettes) throws Exception{
		
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.ModifierMaison(?,?,?,?,?,?,?,?,?,?)}");

		stm.setDouble(1, prix);
		stm.setInt(2, Integer.valueOf(superficie));
		stm.setString(3, adresse);
		stm.setInt(4, nbrechambres);
		stm.setInt(5, nbreetages);
		stm.setInt(6, nbrecuisines);
		stm.setInt(7, nbrebains);
		stm.setInt(8, nbretoilettes);
		stm.setString(9, ville);
		stm.setInt(10, s);
		
		stm.executeUpdate();
		
	}
	
	
	public static void modifier_appartement(int s,double prix, String ville, String superficie,String adresse, int nbrechambres, int numeetage, int nbrecuisines,
			int nbrebains, int nbretoilettes) throws Exception{
		
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.ModifierAppartement(?,?,?,?,?,?,?,?,?)}");

		stm.setDouble(1, prix);
		stm.setInt(2, Integer.valueOf(superficie));
		stm.setString(3, adresse);
		stm.setInt(4, nbrechambres);
		stm.setInt(5, nbrecuisines);
		stm.setInt(6, nbrebains);
		stm.setInt(7, nbretoilettes);
		stm.setString(8, ville);
		stm.setInt(9, s);
		
		stm.executeUpdate();
		
		

	}
	
	
	public static void modifier_terrain(int s,float prix, String adresse, String ville, String superficie, String type) throws Exception{
		
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.ModifierTerrain(?,?,?,?,?,?)}");

		stm.setDouble(1, prix);
		stm.setInt(2, Integer.valueOf(superficie));
		stm.setString(3, adresse);
		stm.setString(4, ville);
		stm.setInt(5, s);
		stm.setString(6, type);

		stm.executeUpdate();
		

		
	}
	
	
	/***********suppression*********/
	public static void supprimer_villa(int s) throws Exception
	{
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.SupprimerVilla(?)}");
		stm.setInt(1, s);
		stm.executeUpdate();

		
	}
	
	
	public static void supprimer_maison(int s) throws Exception{
		
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.SupprimerMaison(?)}");
		stm.setInt(1, s);
		stm.executeUpdate();
		
	}
	
	
	public static void supprimer_appartement(int s) throws Exception
	{
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.SupprimerAppartement(?)}");
		stm.setInt(1, s);
		stm.executeUpdate();
		
	}
	
	
	public static void supprimer_terrain(int s) throws Exception
	{
		Connection conn = Connected.ConnexionMethode();
		CallableStatement stm = conn.prepareCall("{call dbo.SupprimerTerrain(?)}");
		stm.setInt(1, s);
		stm.executeUpdate();
	}
	
	public static ArrayList<String> methodeVilles()throws Exception{
		
		ArrayList<String> villes = new ArrayList<>();
		Connection conn=Connected.ConnexionMethode();
	    CallableStatement cst =conn.prepareCall("{call dbo.VILLES}");
	    
		ResultSet rs=cst.executeQuery();

	    while(rs.next()) {
	    	villes.add(rs.getString(1));
	    }
		
	    return villes;
		
	}
	
	public static ArrayList<String> methodeConnexionAdmin()throws Exception{
		
		ArrayList<String> tab=new ArrayList<>();
		Connection conn= Connected.ConnexionMethode();
		CallableStatement cst =conn.prepareCall("{call dbo.CONNEXION}");
		ResultSet rs=cst.executeQuery();
		while(rs.next()) {
			tab.add(rs.getString(1));
			tab.add(rs.getString(2));
		}
		
		return tab;
	}
	
	
}
