package fr.lteconsulting;

public class Carte
{
	private int id;
	private String nom;
	private String couleur;

	public Carte( int id, String nom, String couleur )
	{
		this.id = id;
		this.nom = nom;
		this.couleur = couleur;
	}

	public int getId()
	{
		return id;
	}

	public String getNom()
	{
		return nom;
	}

	public String getCouleur()
	{
		return couleur;
	}
}
