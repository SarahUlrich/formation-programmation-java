package fr.lteconsulting;

import java.util.List;
import java.util.Random;

public class Application
{
	public static void main( String[] args )
	{
		testBibliotheque();
	}

	static void testBibliotheque()
	{
		Bibliotheque bibliotheque = new Bibliotheque();

		int nbDisques = 40 + new Random().nextInt( 20 );
		while( nbDisques-- > 0 )
		{
			try
			{
				bibliotheque.ajouterDisque( creerDisque() );
			}
			catch( DisqueDejaPresentException e )
			{
				System.out.println( "Duplication de code barre ! C'est pas grave va..." );
			}
		}

		bibliotheque.afficher();

		for( String recherche : new String[] { "Tithon", "dryade", "Ovide", "ovide", "oVIDE" } )
			rechercherDisques( bibliotheque, recherche );
	}

	static void rechercherDisques( Bibliotheque bibliotheque, String recherche )
	{
		System.out.println( "\nRecherche des disques contenant '" + recherche + "'" );
		List<Disque> disques = bibliotheque.rechercherDisques( recherche );
		System.out.println( disques.size() + " disques contiennent le mot " + recherche );
		for( Disque disque : disques )
			System.out.println( "REFERENCE : " + disque.getCodeBarre() + " NOM:" + disque.getNom() );
	}

	static Disque creerDisque()
	{
		Disque disque = new Disque( Mots.phrase(), Integer.toHexString( 1 + new Random().nextInt() ) );

		int nbChansons = 3 + new Random().nextInt( 10 );

		while( nbChansons-- > 0 )
			disque.addChanson( creerChanson() );

		return disque;
	}

	static Chanson creerChanson()
	{
		return new Chanson( Mots.phrase(), 30 + new Random().nextInt( 60 ) );
	}
}
