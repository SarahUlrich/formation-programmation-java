package com.sopra.rest;

import java.util.Random;

import javax.ws.rs.Path;

@Path( "weather" )
public class WeatherWs implements IWeatherWs
{
	@Override
	public boolean isWeatherGood()
	{
		return new Random().nextBoolean();
	}
}
