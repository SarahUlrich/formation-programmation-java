package com.sopra.rest;

public class FunkoPop
{
	private String name;
	private String universe;
	private boolean waterproof;

	public FunkoPop()
	{
	}

	public FunkoPop( String name, String universe, boolean waterproof )
	{
		this.name = name;
		this.universe = universe;
		this.waterproof = waterproof;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getUniverse()
	{
		return universe;
	}

	public void setUniverse( String universe )
	{
		this.universe = universe;
	}

	public boolean isWaterproof()
	{
		return waterproof;
	}

	public void setWaterproof( boolean waterproof )
	{
		this.waterproof = waterproof;
	}
}
