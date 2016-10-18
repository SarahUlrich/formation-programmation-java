package com.sopra.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sopra.rest.buisness.FunkoPopService;

@Path( "pop" )
public class FunkoPopWs
{
	static FunkoPopService service = new FunkoPopService();

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<FunkoPop> getAll()
	{
		return service.findAll();
	}

	@Path( "search" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<FunkoPop> search( @QueryParam( "name" ) String name, @QueryParam( "universe" ) String universe )
	{
		return service.search( name, universe );
	}

	@Path( "urgence" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<FunkoPop> getFunkoPopsToShelter()
	{
		return service.getFunkoPopsToShelter();
	}
}
