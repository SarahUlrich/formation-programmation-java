
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
	}

	static int indexCelluleMin( int[] t, int indexDebutRecherche )
	{
		int iMin = indexDebutRecherche;
		
		for( int i = indexDebutRecherche + 1; i < t.length; i++ )
		{
			if( t[i] < t[iMin] )
				iMin = i;
		}
		
		return iMin;
	}
}
