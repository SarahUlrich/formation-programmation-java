
/**
 * Remarques :
 * 
 * on utilise les long et pas les int car on d�passe rapidement la capacit� des int !
 * 
 * on ne calcule que les 30 premiers termes car c'est tr�s long !
 *
 */
public class Test
{
	public static void main( String[] args )
	{
		max( 2, 3 );
	}

	static long max( long a, long b )
	{
		if( a > b )
			return a;
		else if( b > a )
			return b;
		else if( a == b )
			return a;
		
		// 
		return a;
	}
}
