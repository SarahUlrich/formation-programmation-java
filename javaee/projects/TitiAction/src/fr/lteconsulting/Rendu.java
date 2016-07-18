package fr.lteconsulting;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rendu
{
	public static void pageBienvenue( String nomUtilisateur, ServletContext context, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// fournir a la JSP le nom de l'utilisateur
		// la JSP va chercher ce nom dans l'attribut "nomUtilisateur" de la requête
		request.setAttribute( "nomUtilisateur", nomUtilisateur );

		pagePrincipale( "Bienvenue", "/WEB-INF/accueil.jsp", context, request, response );
	}

	public static void pageLogin( ServletContext context, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		pagePrincipale( "Bienvenue", "/WEB-INF/login.jsp", context, request, response );
	}

	public static void listeCartes( List<Carte> cartes, ServletContext context, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		request.setAttribute( "cartes", cartes );

		Rendu.pagePrincipale( "Liste des cartes à jouer", "/WEB-INF/cartes.jsp", context, request, response );
	}

	public static void pagePrincipale( String title, String contentJsp, ServletContext context, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		request.setAttribute( "pageTitle", title );
		request.setAttribute( "contentJsp", contentJsp );

		RequestDispatcher dispatcher = context.getRequestDispatcher( "/WEB-INF/body.jsp" );

		dispatcher.forward( request, response );
	}
}
