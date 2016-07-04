package fr.lteconsulting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class TestFichiers
{
	static void parcourir( String path )
	{
		File file = new File( path );
		if( file.exists() )
		{
			file.isDirectory();
			file.isFile();
			File[] files = file.listFiles();
			file.getParentFile();
			file.delete();
			file.mkdir();
			file.mkdirs();
			file.length();
		}

		try
		{
			File tempFile = File.createTempFile( "prefix", "suffix" );
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}

	static void lireFichierTexte( String path )
	{
		File file = new File( path );

		FileInputStream fis;
		try
		{
			fis = new FileInputStream( file );

			InputStreamReader isr = new InputStreamReader( fis, "UTF8" );

			BufferedReader reader = new BufferedReader( isr );

			reader.readLine();

			reader.close();

			isr.close();

			fis.close();
		}
		// FileInputStream
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		// InputStreamReader
		catch( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		// reader.readLine();, reader.close(); isr.close(), fis.close()
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}

	static void ecrireFichierTexte( String path )
	{
		boolean utilisePrintWriter = false;

		File file = new File( path );

		try
		{
			FileOutputStream fos = new FileOutputStream( file );

			if( utilisePrintWriter )
			{
				PrintWriter pw = new PrintWriter( fos );

				pw.print( 23 );
				pw.println( "coucou" );

				pw.flush();

				pw.close();
			}
			else
			{
				OutputStreamWriter osw = new OutputStreamWriter( fos, "UTF8" );

				Writer out = new BufferedWriter( osw );

				out.append( "Website UTF-8" ).append( "\r\n" );

				out.flush();

				out.close();

				osw.close();
			}

			fos.close();
		}
		// new FileOutputStream( file );
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		// new OutputStreamWriter( fos, "UTF8" );
		catch( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		// append(), flush() et close()
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}
}
