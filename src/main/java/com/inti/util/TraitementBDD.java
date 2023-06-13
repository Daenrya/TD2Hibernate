package com.inti.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Payment;
import com.inti.model.Utilisateur;

public class TraitementBDD {
	
	private Session session;
	private Logger logger = LogManager.getLogger();
	
	public TraitementBDD() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public List<Utilisateur> getListUtilisateurs()
	{
		List<Utilisateur> listeU = new ArrayList<>();
		try {
			
			session.beginTransaction();
			listeU = session.createNativeQuery("select * from utilisateur", Utilisateur.class).list();
			
			logger.debug("Récupération de la liste des utilisateurs");
		
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de récupération des utilisateurs");
			
			session.getTransaction().rollback();
		}

		return listeU;
	}

	
	
	public void deleteUtilisateur(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.beginTransaction();
			
			Utilisateur u1 = session.load(Utilisateur.class, id);
			
			session.delete(u1);
			
			
			logger.debug("Suppression de l'utilisateur" + u1);
			

			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de suppression de l'utilisateur avec l'id : " + id);
			
			session.getTransaction().rollback();
		}
	}
	
	public Utilisateur getUtilisateurById(int id)
	{
		Utilisateur u1 = null;
		try {
			
			session.beginTransaction();
			
			u1 = session.load(Utilisateur.class, id);
			
		
			logger.debug("Récupération de l'utilisateur" + u1);
			

			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de récupération de l'utilisateur avec l'id : " + id);
			
			session.getTransaction().rollback();
		}
		return u1;
	}
	
	public void updateUtilisateur(int id, String login, String mdp, String adresse, String ville, int cp, String telephone, String mail)
	{
		try {
			
			session.beginTransaction();
			
			Utilisateur u1 = session.load(Utilisateur.class, id);
			u1.setLogin(login);
			u1.setMdp(mdp);
			u1.getUtilisateurDetails().setAdresse(adresse);
			u1.getUtilisateurDetails().setVille(ville);
			u1.getUtilisateurDetails().setCp(cp);
			u1.getUtilisateurDetails().setTelephone(telephone);
			u1.getUtilisateurDetails().setMail(mail);
		
			logger.debug("Modifiaction de l'utilisateur" + u1);
			
			session.update(u1);
			

			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de modification de l'utilisateur avec l'id : " + id);
			
			session.getTransaction().rollback();
		}

	}
	
	public void enregistrerPayment(Payment p)
	{
		try {
			
			session.beginTransaction();
			session.save(p);

			logger.debug("Enregistrement du paiement" + p);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de rl'enregistrement du paiement" + p);
			
			session.getTransaction().rollback();
		}
	}
}
