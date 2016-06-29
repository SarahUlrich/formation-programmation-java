package fr.lteconsulting;

public class Puissance4
{
	private Plateau plateau;

	public Puissance4()
	{
		plateau = new Plateau( 7, 6 );
	}

	public void jouer()
	{
		String nomRouge = Saisie.saisie( "Nom du joueur Rouge" );
		String nomJaune = Saisie.saisie( "Nom du joueur Jaune" );

		JoueurPuissance4[] joueurs = new JoueurPuissance4[2];
		joueurs[0] = new JoueurPuissance4( CouleurPuissance4.Rouge, nomRouge );
		joueurs[1] = new JoueurPuissance4( CouleurPuissance4.Jaune, nomJaune );

		System.out.println( "C'est parti !" );

		int tour = 0;

		while( plateau.possedeCasesVides() && aucunGagnant() )
		{
			plateau.afficher();

			JoueurPuissance4 joueur = joueurs[tour % 2];

			int ligneInsertion;
			int colonneInsertion;
			do
			{
				colonneInsertion = Saisie.saisieInt( "A quelle colonne jouez vous " + joueur.getNom() + " ?" );

				// les index commencent à 1 dans la tête de l'utilisateur
				colonneInsertion = colonneInsertion - 1;

				ligneInsertion = getPremiereLigneVide( colonneInsertion );
				if( ligneInsertion < 0 )
					System.out.println( "NON !!! Pas possible, cette colonne est pleine !!!" );
			}
			while( ligneInsertion < 0 );

			plateau.placer( new Jeton( joueur.getCouleur() ), new Coordonnee( colonneInsertion, ligneInsertion ) );

			tour += 1;
		}
	}

	private boolean aucunGagnant()
	{
		return true;
	}

	private int getPremiereLigneVide( int colonne )
	{
		for( int ligne = 5; ligne >= 0; ligne-- )
		{
			if( plateau.getPieceAt( new Coordonnee( colonne, ligne ) ) == null )
			{
				return ligne;
			}
		}

		return -1;
	}
}
