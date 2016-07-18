package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationData
{
	private static List<Carte> cartes;

	public static List<Carte> getCartes()
	{
		if( cartes == null )
		{
			cartes = new ArrayList<>();
			for( int i = 1; i < 100; i++ )
				cartes.add( new Carte( i, nomCarte(), couleur() ) );
		}

		return cartes;
	}

	public static void removeCarte( int id )
	{
		List<Carte> cartes = getCartes();

		for( int i = 0; i < cartes.size(); i++ )
		{
			Carte carte = cartes.get( i );
			if( carte.getId() == id )
			{
				cartes.remove( i );
				break;
			}
		}
	}

	private static String syllabe()
	{
		String[] mots = { "roi", "da", "me", "pick", "a", "chou", "fou", "bat", "man", "woman", "tra", "tri", "bou", "belz", "crat" };

		return mots[new Random().nextInt( mots.length )];
	}

	private static String nomCarte()
	{
		int nbSyllabes = 1 + new Random().nextInt( 3 );

		StringBuilder sb = new StringBuilder();
		while( nbSyllabes-- > 0 )
			sb.append( syllabe() );

		String res = sb.toString();

		return res.substring( 0, 1 ).toUpperCase() + res.substring( 1 );
	}

	private static String couleur()
	{
		String res = "#";
		for( int i = 0; i < 6; i++ )
			res += "" + new Random().nextInt( 10 );
		return res;
	}
}
