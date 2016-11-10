
/**
 * Remarques :
 * 
 * on utilise les long et pas les int car on dépasse rapidement la capacité des int !
 * 
 * on ne calcule que les 30 premiers termes car c'est très long !
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
