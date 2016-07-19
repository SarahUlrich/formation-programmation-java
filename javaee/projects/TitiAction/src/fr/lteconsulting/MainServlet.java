package fr.lteconsulting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		List<Carte> cartes = new ArrayList<>();

		Set<String> main = (Set<String>) request.getSession().getAttribute( "main" );
		if( main != null )
		{
			for( String id : main )
				cartes.add( ApplicationData.getCarte( id ) );
		}

		Rendu.listeCartes( "Cartes dans votre main", cartes, false, false, getServletContext(), request, response );
	}
}
