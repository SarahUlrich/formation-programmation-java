package fr.lteconsulting.model;

public class Categorie
{
	private Integer id;
	private String nom;
	private int forceMin;
	private int forceMax;

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

	public int getForceMin()
	{
		return forceMin;
	}

	public void setForceMin( int forceMin )
	{
		this.forceMin = forceMin;
	}

	public int getForceMax()
	{
		return forceMax;
	}

	public void setForceMax( int forceMax )
	{
		this.forceMax = forceMax;
	}

	@Override
	public String toString()
	{
		return "Categorie [id=" + id + ", nom=" + nom + ", forceMin=" + forceMin + ", forceMax=" + forceMax + "]";
	}
}
