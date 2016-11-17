
public class Application
{
	public static void main( String[] args )
	{
		Ordinateur o = new Ordinateur(
				"Toto-Numero-4",
				1024,
				new int[] { 133, 222, 666 } );

		o.allumer();
		
		o.eteindre();
	}
}
