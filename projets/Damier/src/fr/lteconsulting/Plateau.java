package fr.lteconsulting;

/**
 * Un plateau est une grille (à deux dimensions) contenant des {@link Piece}.
 */
public class Plateau
{
	/**
	 * La première dimension représente les ordonnées et la deuxième les abscisses
	 */
	private Piece[][] damier;

	public Plateau( int largeur, int hauteur )
	{
		damier = new Piece[hauteur][largeur];
	}

	public void afficher()
	{
		System.out.println();

		for( int l = 0; l < damier.length; l++ )
		{
			Piece[] ligne = damier[l];

			System.out.print( (1 + l) + " " );

			for( Piece piece : ligne )
			{
				if( piece == null )
					System.out.print( "." );
				else
					System.out.print( piece.getDisplayChar() );
			}

			System.out.print( " " + (1 + l) );

			System.out.println();
		}

		System.out.print( "  " );
		for( int i = 0; i < 9; i++ )
		{
			System.out.print( (char)('A' + i) );
		}

		System.out.println();
	}

	public void placer( Piece piece, Coordonnee coordonnee )
	{
		damier[coordonnee.getY()][coordonnee.getX()] = piece;
	}

	public Piece getPieceAt( Coordonnee coordonnee )
	{
		return damier[coordonnee.getY()][coordonnee.getX()];
	}

	public Coordonnee getCoordonneesDePiece( Piece piece )
	{
		for( int indexLigne = 0; indexLigne < damier.length; indexLigne++ )
		{
			Piece[] ligne = damier[indexLigne];
			for( int indexColonne = 0; indexColonne < ligne.length; indexColonne++ )
			{
				Piece p = ligne[indexColonne];
				if( p == piece )
					return new Coordonnee( indexColonne, indexColonne );
			}
		}

		return null;
	}

}
