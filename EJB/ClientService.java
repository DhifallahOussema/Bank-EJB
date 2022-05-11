package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.ClientDao;
import tn.enis.entity.Client;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService {

	@EJB
	private ClientDao clientDao;

	public void save(Client client) {
		clientDao.save(client);
	}

	public Client getById(String cin) { // recherche par PK
		return clientDao.getById(cin);
	}

	public void delete(String cin) {
		clientDao.delete(getById(cin));
	}

	public void update(Client client) {
		clientDao.update(client);
	}

	public List<Client> getAll() {
		return clientDao.getAll();
	}
}
