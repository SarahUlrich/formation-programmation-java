package fr.lteconsulting.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.ApplicationData;

/**
 * Servlet implementation class DeleteCarteServlet
 */
public class DeleteCarteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		try
		{
			String id = request.getParameter( "id" );
			ApplicationData.removeCarte( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		response.sendRedirect( "cartes" );
	}
}
