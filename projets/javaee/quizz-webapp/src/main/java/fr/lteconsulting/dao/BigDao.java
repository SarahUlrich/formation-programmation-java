package fr.lteconsulting.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.lteconsulting.model.Question;
import fr.lteconsulting.model.Quizz;
import fr.lteconsulting.model.Reponse;
import fr.lteconsulting.model.ReponseUtilisateur;
import fr.lteconsulting.model.Utilisateur;

@Stateless
public class BigDao
{
	@PersistenceContext
	private EntityManager em;

	public Quizz findQuizzByName( String quizzName )
	{
		Query q = em.createQuery( "from Quizz q where q.nom=:name" );
		q.setParameter( "name", quizzName );
		try
		{
			return (Quizz) q.getSingleResult();
		}
		catch( NoResultException e )
		{
			return null;
		}
	}

	public void addQuizz( Quizz quizz )
	{
		em.persist( quizz );
	}

	public Quizz findQuizzById( Integer id )
	{
		return em.find( Quizz.class, id );
	}

	public void addQuestion( Question question )
	{
		em.merge( question );
	}

	@SuppressWarnings( "unchecked" )
	public List<Quizz> getQuizzs()
	{
		return em.createQuery( "from Quizz" ).getResultList();
	}

	public List<Question> findQuestionsByQuizzId( Integer quizzId )
	{
		Quizz quizz = findQuizzById( quizzId );
		for( Question q : quizz.getQuestions() )
			q.getReponses();
		return quizz.getQuestions();
	}

	public Reponse findReponseById( int reponseId )
	{
		return em.find( Reponse.class, reponseId );
	}

	public void addReponseUtilisateur( ReponseUtilisateur reponse )
	{
		em.persist( reponse );
	}

	public List<Question> findNextQuestionsForUser( Integer quizzId, Utilisateur utilisateur )
	{
		List<Question> questions = findQuestionsByQuizzId( quizzId );
		List<Question> result = new ArrayList<>();
		for( Question question : questions )
		{
			Query q = em.createQuery( "from ReponseUtilisateur ru left join ru.reponse r where r.question=:question and ru.utilisateur=:utilisateur" );
			q.setParameter( "question", question );
			q.setParameter( "utilisateur", utilisateur );

			if( q.getResultList().isEmpty() )
				result.add( question );
		}

		return result;
	}
}
