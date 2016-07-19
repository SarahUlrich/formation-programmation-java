<%@page import="fr.lteconsulting.Carte"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<c:forEach items="${requestScope['cartes']}" var="carte">
		<div class="col l2 s12">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
					<div class="activator" style="height:17em; background-color:${carte.couleur};"></div>
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">${carte.nom}<i class="material-icons right">more_vert</i></span>
					<p>
						<a href="#">This is a link</a>
					</p>
				</div>
				<div class="card-action">
					<a href="deleteCarte?id=${carte.id}">RETIRER</a>
					<a href="editCarte?ID=${carte.id}">EDITER</a>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">${carte.nom}, détails<i class="material-icons right">close</i></span>
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
								<td>${carte.id}</td>
							</tr>
							<tr>
								<td>Nom</td>
								<td>${carte.nom}</td>
							</tr>
							<tr>
								<td>Couleur</td>
								<td>${carte.couleur}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>
</div>