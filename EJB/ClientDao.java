package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Client;

/**
 * Session Bean implementation class ClientDao
 */
@Singleton
@LocalBean
public class ClientDao {
	@PersistenceContext /* point d'acc�s vers le service de persistance */
	private EntityManager em;

	public void save(Client client) {
		em.persist(client); // stockage dans le base
	}

	public Client getById(String cin) { // recherche par PK
		return em.find(Client.class, cin);
	}

	public void delete(Client client) {
		em.remove(client);
	}

	public void update(Client client) {
		em.merge(client);
	}

	public List<Client> getAll() {
		return em.createQuery("select c from Client c", Client.class).getResultList();
	}
}
