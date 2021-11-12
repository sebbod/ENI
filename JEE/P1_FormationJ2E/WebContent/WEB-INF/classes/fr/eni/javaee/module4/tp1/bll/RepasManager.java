package fr.eni.javaee.module4.tp1.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;
import fr.eni.javaee.module4.tp1.dal.DAOFactory;
import fr.eni.javaee.module4.tp1.dal.RepasDAO;

public class RepasManager {
	private RepasDAO repasDAO;

	public RepasManager() {
		this.repasDAO = DAOFactory.getRepasDAO();
	}

	public Repas ajouterRepas(LocalDate date, LocalTime heure, List<String> listeAliments) throws BusinessException {

		BusinessException businessException = new BusinessException();
		this.validerDateHeure(date, heure, businessException);
		this.validerListeAliments(listeAliments, businessException);

		Repas repas = null;

		if (!businessException.hasErreurs()) {
			repas = new Repas();
			repas.setDate(date);
			repas.setHeure(heure);
			for (String aliment : listeAliments) {
				repas.getListeAliments().add(new Aliment(aliment));
			}
			this.repasDAO.insert(repas);
		} else {
			throw businessException;
		}
		return repas;
	}

	private void validerDateHeure(LocalDate date, LocalTime heure, BusinessException businessException) {
		if (date == null || date.isAfter(LocalDate.now())
				|| (date.isEqual(LocalDate.now()) && heure.isAfter(LocalTime.now()))) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_DATE_ERREUR);
		}

	}

	private void validerListeAliments(List<String> listeAliments, BusinessException businessException) {
		if (listeAliments == null || listeAliments.size() == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_ALIMENTS_ERREUR);
		} else {
			for (String aliment : listeAliments) {
				if (aliment.length() > 50) {
					businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_ALIMENTS_ERREUR);
					break;
				}
			}
		}

	}

	public List<Repas> selectionnerTousLesRepas() throws BusinessException {
		return this.repasDAO.select();
	}

	public List<Repas> selectionnerTousLesRepasDUnJour(LocalDate dateFiltre) throws BusinessException {
		return this.repasDAO.select(dateFiltre);
	}

}
