package fr.eni.javaee.module9.tp1.bll;

import java.util.Date;
import java.util.List;

import fr.eni.javaee.module9.tp1.BusinessException;
import fr.eni.javaee.module9.tp1.bo.Note;
import fr.eni.javaee.module9.tp1.dal.DAOFactory;
import fr.eni.javaee.module9.tp1.dal.NoteDAO;

public class NoteManager {
	private NoteDAO noteDAO;

	public NoteManager() {
		noteDAO = DAOFactory.getNoteDAO();
	}

	public List<Note> selectionnerNotes() throws BusinessException {
		return noteDAO.selectAll();
	}

	public Note selectionnerNote(int idNote) throws BusinessException {
		return noteDAO.selectById(idNote);
	}

	public Note ajouterNote(String contenu) throws BusinessException {
		BusinessException businessException = new BusinessException();

		validerContenu(contenu, businessException);

		if (businessException.hasErreurs()) {
			throw businessException;
		}

		Note nouvelleNote = new Note(contenu, new Date());

		noteDAO.insert(nouvelleNote);

		return nouvelleNote;
	}

	public void supprimerNote(int idNote) throws BusinessException {
		noteDAO.delete(idNote);
	}

	public void updateNote(int idNote, String contenu) throws BusinessException {
		BusinessException businessException = new BusinessException();

		validerContenu(contenu, businessException);

		if (businessException.hasErreurs()) {
			throw businessException;
		}

		Note noteAModifier = new Note(idNote, contenu, new Date());
		noteDAO.update(noteAModifier);

	}

	private void validerContenu(String contenu, BusinessException businessException) {
		if (contenu == null || contenu.trim().length() > 500) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_LISTE_NOM_ERREUR);
		}
	}

}
