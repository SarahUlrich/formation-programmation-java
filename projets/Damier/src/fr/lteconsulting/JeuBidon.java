package fr.lteconsulting;

public class JeuBidon
{
	private Plateau plateau;

	public JeuBidon()
	{
		plateau = new Plateau( 13, 5 );
	}

	public void jouer()
	{
		while( true )
		{
			// Poser la question : "Voulez-vous ajouter une pièce ?"
			String reponseAjoutPiece = Saisie.saisie( "Voulez-vous ajouter une pièce ? (oui/non)" );

			if( !"oui".equalsIgnoreCase( reponseAjoutPiece ) )
			{
				System.out.println( "Bravo tu as bien joué, à bientôt..." );
				return;
			}
			else
			{
				// Si la réponse est OUI :
				Coordonnee coordonnee = Saisie.saisieCoordonnee( "A quelle coordonnée ? (abscisse;ordonnee)" );

				CouleurNB couleur = Saisie.saisieCouleurNB( "De quelle couleur ?" );

				// Placer une nouvelle pièce sur le plateau à l'endroit choisi par l'utilisateur.
				plateau.placer( new Dame( couleur ), coordonnee );

				// Afficher le tableau
				plateau.afficher();

				// Recommencer
			}
		}
	}
}
