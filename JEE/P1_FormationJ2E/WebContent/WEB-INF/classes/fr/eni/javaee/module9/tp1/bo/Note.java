package fr.eni.javaee.module9.tp1.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

	private int id;
	private String contenu;
	private Date date;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy -- HH:mm");

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Note() {
	}

	public Note(String contenu, Date date) {
		this.contenu = contenu;
		this.date = date;
	}

	public Note(int id, String contenu, Date date) {
		this(contenu, date);
		this.id = id;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", contenu=" + contenu + ", date=" + sdf.format(date) + "]";
	}

}
