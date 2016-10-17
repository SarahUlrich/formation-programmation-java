package com.sopra.rest.buisness;

import java.util.ArrayList;
import java.util.List;
import com.sopra.rest.FunkoPop;

public class FunkoPopService
{
	List<FunkoPop> pops = new ArrayList<>();

	public FunkoPopService()
	{
		pops.add( new FunkoPop( "Gandalf", "Lord of the Ring" ) );
		pops.add( new FunkoPop( "Alf", "Alf" ) );
		pops.add( new FunkoPop( "Joey Tempest", "Europe" ) );
		pops.add( new FunkoPop( "ZombiGirl", "Walking Dead" ) );
	}

	public List<FunkoPop> findAll()
	{
		return pops;
	}

	public void addFunkoPop( String name, String universe )
	{
		this.pops.add( new FunkoPop( name, universe ) );
	}
}
