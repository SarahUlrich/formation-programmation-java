
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

	static long fibonacci( long n )
	{
		// on écrit d'abord les cas bien définis ...
		if( n == 0 )
			return 0;
		else if( n == 1 )
			return 1;

		// ... puis la récursion
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
}
