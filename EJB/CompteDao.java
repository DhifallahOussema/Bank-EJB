package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteDao
 */
@Singleton
@LocalBean
public class CompteDao {
	@PersistenceContext /* point d'acc�s vers le service de persistance */
	private EntityManager em;

	public void save(Compte compte) {
		em.persist(compte); // stockage dans le base
	}

	public Compte getById(Long rib) { // recherche par PK
		return em.find(Compte.class, rib);
	}

	public void delete(Compte compte) {
		em.remove(compte);
	}

	public void update(Compte compte) {
		em.merge(compte);
	}

	public List<Compte> getAll() {
		return em.createQuery("select c from Compte c", Compte.class).getResultList();
	}

	public List<Compte> getAllByClient(String cin) { // EJB-QL/JP-QL: Orient� Objet
		return em.createQuery("select c from Compte c where c.client.cin=:cin", Compte.class).setParameter("cin", cin)
				.getResultList();
	}

}
