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

		int nbRechercheDisque = 5;
		while( nbRechercheDisque-- > 0 )
		{
			String recherche = Mots.mot();

			String codeBarre = rechercherDisques( bibliotheque, recherche );
			if( codeBarre != null )
			{
				System.out.println( "Recher et détails du disque " + codeBarre );
				Disque disque = bibliotheque.getDisque( codeBarre );
				disque.afficher();
			}
		}

		int nbRechercheChanson = 5;
		while( nbRechercheChanson-- > 0 )
		{
			String recherche = Mots.mot();

			rechercheChansons( bibliotheque, recherche );
		}
	}

	/**
	 * Retourne un des code barres des disques trouvés
	 * 
	 * @param bibliotheque
	 * @param recherche
	 * @return
	 */
	static String rechercherDisques( Bibliotheque bibliotheque, String recherche )
	{
		String codeBarre = null;

		System.out.println( "\nRecherche des disques contenant '" + recherche + "'" );
		List<Disque> disques = bibliotheque.rechercherDisques( recherche );
		System.out.println( disques.size() + " disques contiennent le mot " + recherche );
		for( Disque disque : disques )
		{
			if( codeBarre == null )
				codeBarre = disque.getCodeBarre();

			System.out.println( "REFERENCE : " + disque.getCodeBarre() + " NOM:" + disque.getNom() );
		}

		return codeBarre;
	}

	static void rechercheChansons( Bibliotheque bibliotheque, String recherche )
	{
		System.out.println( "\nRecherche des chansons contenant '" + recherche + "'" );

		List<Chanson> chansons = bibliotheque.rechercherChansons( recherche );

		System.out.println( chansons.size() + " chansons contiennent le mot " + recherche );

		for( Chanson chanson : chansons )
		{
			Disque disque = chanson.getDisque();
			System.out.println( "- '" + chanson.getNom() + "' dans le disque " + disque.getNom() + " (ref:" + disque.getCodeBarre() + ")" );
		}
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
