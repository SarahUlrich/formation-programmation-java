package fr.lteconsulting;

public class Application
{
	public static void main( String[] args )
	{
		System.out.println( "=== INITIALISATION ===" );

		Compte ccp = new Compte( "87 166 33 K 202", 2000 );
		Client client1 = new Client( "Jean Boulle", ccp );

		Compte livretA = new CompteRemunere( "99 654 44 Z 661", 3000, 0.2 );
		Client client2 = new Client( "Biloutte Dupond", livretA );

		client1.afficher();
		client2.afficher();

		System.out.println( "=== TRANSFERT BANCAIRE ===" );

		Banque banque = new Banque();
		banque.transferer( client1, client2, 123 );

		System.out.println( "=== APRES TRANSFERT ===" );

		client1.afficher();
		client2.afficher();

		System.out.println( "=== VERSEMENT DES INTERETS ===" );

		// A la fin de l'année on verse les interets...
		banque.verserInterets( ccp );
		banque.verserInterets( livretA );
	}
}
