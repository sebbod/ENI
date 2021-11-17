package fr.eni.javaee.module9.tp1.dal;

public abstract class DAOFactory {

	public static NoteDAO getNoteDAO() {
		return new NoteDAOJdbcImpl();
	}
}
