package fr.eni.javaee.module6.tp1.dal;

public abstract class DAOFactory {

	public static ListeCourseDAO getListeCourseDAO() {
		return new ListeCourseDAOJdbcImpl();
	}
}
