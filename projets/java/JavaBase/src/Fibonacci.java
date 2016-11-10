
/**
 * Remarques :
 * 
 * on utilise les long et pas les int car on dépasse rapidement la capacité des int !
 * 
 * on ne calcule que les 30 premiers termes car c'est très long !
 *
 */
public class Fibonacci
{
	public static void main( String[] args )
	{
		for( int i = 1; i <= 100; i++ )
		{
			System.out.println( "Le " + i + "ème terme de la série de Fibonacci vaut " + fibonacci( i ) );
		}
	}

	// calcul du n-ième terme de la suite de fibonacci
	static int fibonacci( int n )
	{
		/*
		 * Définition de la suite de Fibonacci:
		 * 
		 * - F(0) : 0
		 * - F(1) : 1
		 * - F(n) : F(n-1) + F(n-2)
		 */

		// cas terminaux
		if( n == 0 )
			return 0;
		else if( n == 1 )
			return 1;

		// cas général
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
}
