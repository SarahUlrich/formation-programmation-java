package fr.lteconsulting.puissance4;

import fr.lteconsulting.Piece;

public class Jeton extends Piece
{
	private CouleurPuissance4 couleur;

	public Jeton( CouleurPuissance4 couleur )
	{
		this.couleur = couleur;
	}

	@Override
	public char getDisplayChar()
	{
		switch( couleur )
		{
			case Jaune:
				return '0';
			case Rouge:
				return '#';
		}
		return '?';
	}

	public CouleurPuissance4 getCouleur()
	{
		return couleur;
	}
}
