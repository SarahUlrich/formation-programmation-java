package fr.lteconsulting;

public enum CouleurNB
{
	Noir( 'N' ),
	Blanc( 'b' ),
	Rouge( 'R' );

	private char displayChar;

	CouleurNB( char displayChar )
	{
		this.displayChar = displayChar;
	}

	public char getDisplayChar()
	{
		return displayChar;
	}
}
