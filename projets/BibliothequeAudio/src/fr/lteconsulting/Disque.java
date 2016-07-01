package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class Disque
{
	private String nom;
	private String codeBarre;
	private List<Chanson> chansons;

	public Disque( String nom, String codeBarre )
	{
		this.nom = nom;
		this.codeBarre = codeBarre;
		this.chansons = new ArrayList<>();
	}

	public void addChanson( Chanson chanson )
	{
		chansons.add( chanson );
		chanson.setDisque( this );
	}

	public int getDuree()
	{
		int duree = 0;
		for( Chanson chanson : chansons )
			duree += chanson.getDuree();
		return duree;
	}

	public String getNom()
	{
		return nom;
	}

	public String getCodeBarre()
	{
		return codeBarre;
	}

	public List<Chanson> getChansons()
	{
		return chansons;
	}

	public void afficher()
	{
		System.out.println( "DISQUE " + nom + " REFERENCE : " + codeBarre );
		for( int i = 0; i < chansons.size(); i++ )
		{
			System.out.print( (1 + i) + ". " );
			chansons.get( i ).afficher();
		}
	}
}
