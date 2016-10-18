package com.sopra.rest.buisness;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.sopra.rest.FunkoPop;
import com.sopra.rest.IWeatherWs;

public class FunkoPopService
{
	List<FunkoPop> pops = new ArrayList<>();

	public FunkoPopService()
	{
		pops.add( new FunkoPop( "Gandalf", "Lord of the Ring", true ) );
		pops.add( new FunkoPop( "Alf", "Alf", false ) );
		pops.add( new FunkoPop( "Joey Tempest", "Europe", false ) );
		pops.add( new FunkoPop( "ZombiGirl", "Walking Dead", true ) );
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

	public List<FunkoPop> getFunkoPopsToShelter()
	{
		// savoir s'il fait beau ou pas
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target( "http://localhost:8080/WeatherWS/weather/isWeatherGood" );
		IWeatherWs simple = target.proxy( IWeatherWs.class );
		boolean weatherGood = simple.isWeatherGood();

		List<FunkoPop> result = new ArrayList<>();

		if( !weatherGood )
		{
			for( FunkoPop pop : pops )
			{
				if( !pop.isWaterproof() )
					result.add( pop );
			}
		}

		return result;
	}

	public void addFunkoPop( String name, String universe, boolean waterproof )
	{
		this.pops.add( new FunkoPop( name, universe, waterproof ) );
	}

	private boolean isValid( String value, String criteria )
	{
		return criteria == null || (value != null && value.contains( criteria ));
	}
}
