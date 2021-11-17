package fr.eni.javaee.module9.tp1.dal;

import java.util.List;

import fr.eni.javaee.module9.tp1.BusinessException;
import fr.eni.javaee.module9.tp1.bo.Note;

public interface NoteDAO {
	public void insert(Note note) throws BusinessException;

	public void delete(int id) throws BusinessException;

	public void update(Note note) throws BusinessException;

	public List<Note> selectAll() throws BusinessException;

	public Note selectById(int id) throws BusinessException;
}
