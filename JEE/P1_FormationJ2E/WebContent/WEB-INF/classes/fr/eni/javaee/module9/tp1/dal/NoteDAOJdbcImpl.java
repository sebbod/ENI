package fr.eni.javaee.module9.tp1.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.module9.tp1.BusinessException;
import fr.eni.javaee.module9.tp1.bo.Note;

public class NoteDAOJdbcImpl implements NoteDAO {

	private static final String SELECT_ALL = "SELECT * FROM Notes";

	private static final String SELECT_BY_ID = SELECT_ALL + " WHERE id=?";

	private static final String INSERT_NOTE = "INSERT INTO Notes(contenu, date) VALUES(?,?);";

	private static final String DELETE_NOTE = "DELETE FROM Notes WHERE id=?";

	private static final String UPDATE_NOTE = "UPDATE Notes set contenu=?, date=? WHERE id=?";

	@Override
	public void insert(Note note) throws BusinessException {
		if (note == null) {
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_NOTE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, note.getContenu());
			pstmt.setDate(2, new java.sql.Date(note.getDate().getTime()));
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				note.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int id) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_NOTE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
			throw businessException;
		}

	}

	@Override
	public List<Note> selectAll() throws BusinessException {
		List<Note> notes = new ArrayList<Note>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				notes.add(map(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return notes;
	}

	@Override
	public Note selectById(int id) throws BusinessException {
		Note result = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = map(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}

		if (result == null) {
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
		}

		return result;
	}

	@Override
	public void update(Note note) throws BusinessException {
		if (note == null) {
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_NOTE);
			pstmt.setString(1, note.getContenu());
			pstmt.setDate(2, new java.sql.Date(note.getDate().getTime()));
			pstmt.setInt(3, note.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	private Note map(ResultSet rs) throws SQLException {

		int id = rs.getInt("id");
		String contenu = rs.getString("contenu");
		Date date = rs.getDate("date");

		return new Note(id, contenu, date);
	}
}
