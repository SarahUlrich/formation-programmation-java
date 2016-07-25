package fr.lteconsulting.model;

public class Categorie
{
	private Integer id;
	private String nom;
	private int force;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public int getForce()
	{
		return force;
	}

	public void setForce( int force )
	{
		this.force = force;
	}

	@Override
	public String toString()
	{
		return "Categorie [id=" + id + ", nom=" + nom + ", force=" + force + "]";
	}
}
