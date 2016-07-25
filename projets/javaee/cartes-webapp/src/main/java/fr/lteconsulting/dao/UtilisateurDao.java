package fr.lteconsulting.dao;

import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.model.Utilisateur;

public class UtilisateurDao
{
	private static UtilisateurDao instance = new UtilisateurDao();

	private UtilisateurDao()
	{
		Utilisateur rootUser = new Utilisateur();
		rootUser.setId( 1 );
		rootUser.setNom( "Tournier" );
		rootUser.setPrenom( "Arnaud" );
		rootUser.setAge( 24 );
		rootUser.setLogin( "ltearno" );
		rootUser.setMotDePasse( "ltearno" );

		utilisateurs.add( rootUser );
	}

	public static UtilisateurDao get()
	{
		return instance;
	}

	private List<Utilisateur> utilisateurs = new ArrayList<>();

	private int nextId = 4;

	public List<Utilisateur> getUtilisateurs()
	{
		return utilisateurs;
	}

	public void add( Utilisateur utilisateur )
	{
		utilisateur.setId( nextId++ );

		utilisateurs.add( utilisateur );
	}

	public void save( Utilisateur utilisateur )
	{
		int index = indexOfUtilisateur( utilisateur.getId() );

		if( index >= 0 )
			utilisateurs.set( index, utilisateur );
	}

	public void delete( int id )
	{
		int index = indexOfUtilisateur( id );

		if( index >= 0 )
			utilisateurs.remove( index );
	}

	public Utilisateur login( String login, String motDePasse )
	{
		for( Utilisateur u : utilisateurs )
		{
			if( u.getLogin().equals( login ) && u.getMotDePasse().equals( motDePasse ) )
				return u;
		}

		return null;
	}

	private int indexOfUtilisateur( int id )
	{
		for( int i = 0; i < utilisateurs.size(); i++ )
			if( utilisateurs.get( i ).getId() == id )
				return i;

		return -1;
	}

	public Utilisateur trouverUtilisateurParLogin( String login )
	{
		for( Utilisateur u : utilisateurs )
		{
			if( u.getLogin().equals( login ) )
				return u;
		}

		return null;
	}
}