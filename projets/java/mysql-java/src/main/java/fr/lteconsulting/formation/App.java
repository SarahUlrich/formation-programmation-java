package fr.lteconsulting.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
	public static void main( String[] args )
	{
		try
		{
			System.out.println( "Enregistrement du driver..." );
			Class.forName( "com.mysql.jdbc.Driver" );

			System.out.println( "Ouverture de la connexion à la base de données" );
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/cartes", "root", null );
			
			conn.setAutoCommit( false );

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery( "SELECT id, nom, couleur from carte" );
			while( rs.next() )
			{
				String id = rs.getString( "id" );
				String nom = rs.getString( "nom" );
				String couleur = rs.getString( "couleur" );

				System.out.printf( "%s %s %s\n", id, nom, couleur );
			}
			
			//conn.createStatement().executeUpdate( "update `carte` set nom='titi'" );
			
			conn.rollback();

			System.out.println( "Fermeture de la connexion à la base de données" );
			conn.close();
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( "Ne parvient pas à trouver le driver JDBC !!" );
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
	}
}
