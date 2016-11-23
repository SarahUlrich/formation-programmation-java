package fr.lteconsulting.formations;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;

import fr.lteconsulting.formations.model.Collaborateur;

public class CSVReaderTest
{
	@Test
	public void test()
	{
		try
		{
			Reader in = new FileReader( "sopra-modified.csv" );
			Iterable<CSVRecord> records = CSVFormat.RFC4180
					.withDelimiter( ';' )
					.withQuote( '"' )
					.withFirstRecordAsHeader()
					.parse( in );
			for( CSVRecord record : records )
			{
				// record.get( "Mois" );

				Collaborateur collaborateur = new Collaborateur();
				collaborateur.setCodeAgence( record.get( "Agence" ) );
				collaborateur.setNom( record.get( "Nom du collaborateur" ) );
				collaborateur.setPrenom( record.get( "Prénom du collaborateur" ) );

				record.get( "Nb jours" );
				record.get( "Date attendue" );
				record.get( "Date réelle" );
				record.get( "Intitulé de la formation" );
				record.get( "Lieu de formation" );
				record.get( "Organisme ext / Formateur interne" );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}
