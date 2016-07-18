<%@page import="fr.lteconsulting.Carte"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<Carte> cartes = (List<Carte>) request.getAttribute( "cartes" );
%>

<div class="row">
	<%
		for( Carte carte : cartes )
		{
	%>
	<div class="col l2 s12">
		<div class="card">
			<div class="card-image waves-effect waves-block waves-light">
				<div class="activator" style="height:17em; background-color:<%= carte.getCouleur() %>;"></div>
			</div>
			<div class="card-content">
				<span class="card-title activator grey-text text-darken-4"><%= carte.getNom() %><i class="material-icons right">more_vert</i></span>
				<p>
					<a href="#">This is a link</a>
				</p>
			</div>
			<div class="card-action">
				<a href="deleteCarte?id=<%= carte.getId() %>">RETIRER</a>
			</div>
			<div class="card-reveal">
				<span class="card-title grey-text text-darken-4"><%= carte.getNom() %>, détails<i class="material-icons right">close</i></span>
				<p>Voici les principaux attributs de cette carte.</p>
				<table>
					<thead>
						<tr>
							<th data-field="name">Attribut</th>
							<th data-field="valeur">Valeur</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td>ID</td>
							<td><%= carte.getId() %></td>
						</tr>
						<tr>
							<td>Nom</td>
							<td><%= carte.getNom() %></td>
						</tr>
						<tr>
							<td>Couleur</td>
							<td><%= carte.getCouleur() %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%
		}
	%>
</div>