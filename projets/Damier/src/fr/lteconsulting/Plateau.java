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

	private int largeur;

	public Plateau( int largeur, int hauteur )
	{
		this.largeur = largeur;

		damier = new Piece[hauteur][largeur];
	}

	public void afficher()
	{
		System.out.println();

		afficherBordHaut();

		afficherEchelleHorizontaleRomaine();

		for( int l = 0; l < damier.length; l++ )
		{
			Piece[] ligne = damier[l];

			System.out.print( "| " );

			int numeroLigne = l + 1;
			System.out.printf( "%2d ", numeroLigne );

			for( Piece piece : ligne )
			{
				if( piece == null )
					System.out.print( "." );
				else
					System.out.print( piece.getDisplayChar() );
			}

			System.out.printf( " %2d |", numeroLigne );

			System.out.println();
		}

		afficherEchelleHorizontaleNaturelle();

		afficherBordBas();
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

	private void afficherBordHaut()
	{
		System.out.print( "/" );
		for( int i = 0; i < 8 + largeur; i++ )
			System.out.print( "-" );
		System.out.println( "\\" );
	}

	private void afficherBordBas()
	{
		System.out.print( "\\" );
		for( int i = 0; i < 8 + largeur; i++ )
			System.out.print( "-" );
		System.out.println( "/" );
	}

	private void afficherEchelleHorizontaleRomaine()
	{
		System.out.print( "|    " );
		for( int i = 0; i < largeur; i++ )
		{
			int dizaine = i / 26;
			System.out.print( (char) ('A' + dizaine) );
		}
		System.out.println( "    |" );

		System.out.print( "|    " );
		for( int i = 0; i < largeur; i++ )
		{
			int unite = i % 26;
			System.out.print( (char) ('A' + unite) );
		}
		System.out.println( "    |" );
	}

	private void afficherEchelleHorizontaleNaturelle()
	{
		System.out.print( "|    " );
		for( int i = 1; i <= largeur; i++ )
		{
			int dizaine = i / 10;

			System.out.printf( "%1d", dizaine );
		}
		System.out.println( "    |" );

		System.out.print( "|    " );
		for( int i = 1; i <= largeur; i++ )
		{
			int unite = i % 10;

			System.out.printf( "%1d", unite );
		}
		System.out.println( "    |" );
	}
}
