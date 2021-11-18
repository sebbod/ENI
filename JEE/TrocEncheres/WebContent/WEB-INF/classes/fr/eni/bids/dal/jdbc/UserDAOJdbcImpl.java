package fr.eni.bids.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.bids.BusinessException;
import fr.eni.bids.bo.User;
import fr.eni.bids.dal.ConnectionProvider;
import fr.eni.bids.dal.DALException;
import fr.eni.bids.dal.ErrorDAL;
import fr.eni.bids.dal.UserDAO;

public class UserDAOJdbcImpl implements UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.UserDAO#getById(java.lang.Integer)
	 */
	@Override
	public User getById(Integer id) throws DALException {
		// TODO Auto-generated method stub
		return UserDAO.super.getById(id);
		User user = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			prepStmt = cnx.prepareStatement(SQL_QUERY.USER_GET_BY_ID);
			prepStmt.setInt(1, id);
			rs = prepStmt.executeQuery();
			if (rs.next()) {
				user = DalUtils.buildUser(rs);
			}
		} catch (SQLException e) {
			BusinessException businessException = new fr.eni.bids.BusinessException();
			businessException.ajouterErreur(ErrorDAL.READ_ERROR);
			e.printStackTrace();
			throw businessException;
		} finally {
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.UserDAO#getAll()
	 */
	@Override
	public List<User> getAll() throws DALException {
		// TODO Auto-generated method stub
		return UserDAO.super.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.UserDAO#insert(fr.eni.bids.bo.User)
	 */
	@Override
	public void insert(User data) throws DALException {
		// TODO Auto-generated method stub
		UserDAO.super.insert(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.UserDAO#update(fr.eni.bids.bo.User)
	 */
	@Override
	public void update(User data) throws DALException {
		// TODO Auto-generated method stub
		UserDAO.super.update(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.UserDAO#delete(fr.eni.bids.bo.User)
	 */
	@Override
	public void delete(User obj) throws DALException {
		// TODO Auto-generated method stub
		UserDAO.super.delete(obj);
	}

}
