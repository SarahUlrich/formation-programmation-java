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

	public List<FunkoPop> search( String name, String universe )
	{
		List<FunkoPop> result = new ArrayList<>();

		for( FunkoPop pop : pops )
		{
			if( isValid( pop.getName(), name ) && isValid( pop.getUniverse(), universe ) )
				result.add( pop );
		}

		return result;
	}

	public void addFunkoPop( String name, String universe )
	{
		this.pops.add( new FunkoPop( name, universe ) );
	}

	private boolean isValid( String value, String criteria )
	{
		return criteria == null || (value != null && value.contains( criteria ));
	}
}
