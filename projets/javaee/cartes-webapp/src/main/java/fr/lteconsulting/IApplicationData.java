package fr.lteconsulting;

import java.util.List;

import fr.lteconsulting.model.Carte;

public interface IApplicationData
{
	List<Carte> getCartes();

	void ajouterCarte( Carte carte );

	void removeCarte( String id );

	Carte getCarte( String id );
}
