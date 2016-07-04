package fr.lteconsulting;

import java.util.List;
import java.util.Random;

public class Application
{
	public static void main( String[] args )
	{
		// testBibliotheque();
		run();
	}

	static void run()
	{
		Bibliotheque bibliotheque = creerBibliothequeDeTest();

		System.out.println( "Initialisation OK..." );

		menuPrincipal( bibliotheque );
	}

	static void menuPrincipal( Bibliotheque bibliotheque )
	{
		while( true )
		{
			System.out.println( "\n## MENU PRINCIPAL ##\n" );
			System.out.println( "1. Chercher des disques" );
			System.out.println( "2. Chercher des chansons" );
			System.out.println( "3. Détails d'un disque" );
			System.out.println( "4. Quitter" );

			int choix = Saisie.saisieInt( "Entrez le numéro du choix" );

			switch( choix )
			{
				case 1:
					rechercherDisques( bibliotheque );
					break;
				case 2:
					rechercherChansons( bibliotheque );
					break;
				case 3:
					detailsDisque( bibliotheque );
					break;
				case 4:
					System.out.println( "Bye bye !" );
					return;
				default:
					System.out.println( "Choix non disponible..." );
			}
		}
	}

	static void rechercherDisques( Bibliotheque bibliotheque )
	{
		System.out.println( "\n## RECHERCHE DISQUES ##\n" );
		String recherche = Saisie.saisie( "Saisissez la chaine de recherche" );
		rechercherDisques( bibliotheque, recherche );
	}

	static void rechercherChansons( Bibliotheque bibliotheque )
	{
		System.out.println( "\n## RECHERCHE CHANSONS ##\n" );
		String recherche = Saisie.saisie( "Saisissez la chaine de recherche" );
		rechercherChansons( bibliotheque, recherche );
	}

	static void detailsDisque( Bibliotheque bibliotheque )
	{
		System.out.println( "\n## DETAILS DISQUE ##\n" );
		String codeBarre = Saisie.saisie( "Saisissez le code barre du dsique à afficher" );
		Disque disque = bibliotheque.getDisque( codeBarre );
		if( disque == null )
		{
			System.out.println( "Aucun disque trouvé..." );
		}
		else
		{
			System.out.println( "Disque trouvé, affichage des détails :" );
			disque.afficher();
		}
	}

	static Bibliotheque creerBibliothequeDeTest()
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

		return bibliotheque;
	}

	static void testBibliotheque()
	{
		Bibliotheque bibliotheque = creerBibliothequeDeTest();

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

			rechercherChansons( bibliotheque, recherche );
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

	static void rechercherChansons( Bibliotheque bibliotheque, String recherche )
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
