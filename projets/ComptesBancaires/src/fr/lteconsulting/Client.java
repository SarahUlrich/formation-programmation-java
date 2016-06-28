package fr.lteconsulting;

public class Client
{
	private String nom;

	// TODO : plusieurs comptes avec ArrayList<>
	private Compte compte;

	public Client( String nom, Compte compte )
	{
		this.nom = nom;
		this.compte = compte;
	}

	public String getNom()
	{
		return nom;
	}

	public Compte getCompte()
	{
		return compte;
	}

	public void afficher()
	{
		System.out.println( "Client '" + nom + "'" );
		compte.afficher();
	}
}
