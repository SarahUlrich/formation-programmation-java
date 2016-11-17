
public class DisqueDur
{
	int capacite;

	DisqueDur( int capacite )
	{
		this.capacite = capacite;
	}

	void demarrer()
	{
		System.out.println( "Démarrage " + getDescription() );
	}

	void lire()
	{
		System.out.println( "Lecture " + getDescription() );
	}

	void eteindre()
	{
		System.out.println( "Extinction " + getDescription() );
	}

	String getDescription()
	{
		return "DisqueDur de capacité " + capacite;
	}
}
