package fr.eni.javaee.module9.tp1.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.eni.javaee.module9.tp1.BusinessException;
import fr.eni.javaee.module9.tp1.bll.NoteManager;
import fr.eni.javaee.module9.tp1.bo.Note;

@Path("/notes")
public class GestionNotes {

	@GET
	public List<Note> getNotes() throws BusinessException {
		NoteManager mgt = new NoteManager();
		return mgt.selectionnerNotes();
	}

	@PUT
	@Path("/{id:\\d+}")
	public void modifierNote(@PathParam("id") int id, @FormParam("paramContenu") String contenu)
			throws BusinessException {
		NoteManager mgt = new NoteManager();
		mgt.updateNote(id, contenu);
	}

	@DELETE
	@Path("/{id:\\d+}")
	public void supprimerNote(@PathParam("id") int id) throws BusinessException {
		NoteManager mgt = new NoteManager();
		mgt.supprimerNote(id);
	}

	@POST
	public void ajouterNote(@FormParam("paramContenu") String contenu) throws BusinessException {
		NoteManager mgt = new NoteManager();
		mgt.ajouterNote(contenu);
	}

}
