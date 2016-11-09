
/**
 * Remarques :
 * 
 * on utilise les long et pas les int car on d�passe rapidement la capacit� des int !
 * 
 * on ne calcule que les 30 premiers termes car c'est tr�s long !
 *
 */
public class Fibonacci
{
	public static void main( String[] args )
	{
		for( int i = 1; i <= 100; i++ )
		{
			System.out.println( "Le " + i + "�me terme de la s�rie de Fibonacci vaut " + fibonacci( i ) );
		}
	}

	static long fibonacci( long n )
	{
		// on �crit d'abord les cas bien d�finis ...
		if( n == 0 )
			return 0;
		else if( n == 1 )
			return 1;

		// ... puis la r�cursion
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
}
