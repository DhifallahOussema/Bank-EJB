package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.CompteDao;
import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteService
 */
@Stateless
@LocalBean
public class CompteService {

	@EJB
	private CompteDao compteDao;

	public void save(Compte compte) {
		compteDao.save(compte);
	}

	public Compte getById(Long rib) { // recherche par PK
		return compteDao.getById(rib);
	}

	public void delete(Long rib) {
		compteDao.delete(getById(rib));
	}

	public void update(Compte compte) {
		compteDao.update(compte);
	}

	public List<Compte> getAll() {
		return compteDao.getAll();
	}

	public List<Compte> getAllByClient(String cin) { // EJB-QL/JP-QL: Orient� Objet
		return compteDao.getAllByClient(cin);
	}
}
