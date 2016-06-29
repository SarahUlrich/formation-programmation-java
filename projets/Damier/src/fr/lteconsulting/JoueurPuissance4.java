package fr.lteconsulting;

public class JoueurPuissance4
{
	private CouleurPuissance4 couleur;
	private String nom;

	public JoueurPuissance4( CouleurPuissance4 couleur, String nom )
	{
		this.couleur = couleur;
		this.nom = nom;
	}

	public CouleurPuissance4 getCouleur()
	{
		return couleur;
	}

	public String getNom()
	{
		return nom;
	}
}
