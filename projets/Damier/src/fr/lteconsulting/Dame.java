package fr.lteconsulting;

public class Dame extends Piece
{
	private CouleurNB couleur;

	public Dame( CouleurNB couleur )
	{
		this.couleur = couleur;
	}

	@Override
	public char getDisplayChar()
	{
		switch( couleur )
		{
			case Noir:
				return 'N';
			case Blanc:
				return 'B';
		}

		return '?';
	}

}
