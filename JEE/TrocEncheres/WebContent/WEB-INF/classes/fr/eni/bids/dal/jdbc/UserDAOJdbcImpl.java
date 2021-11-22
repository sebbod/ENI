package fr.eni.bids.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.bids.bo.User;
import fr.eni.bids.dal.ConnectionProvider;
import fr.eni.bids.dal.DALException;
import fr.eni.bids.dal.UserDAO;

public class UserDAOJdbcImpl implements UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.UserDAO#getById(java.lang.Integer)
	 */
	@Override
	public User getById(Integer id) throws DALException {
		User user = new User();
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			prepStmt = cnx.prepareStatement(SQL_QUERY.USER_GET_BY_ID);
			prepStmt.setInt(1, id);
			rs = prepStmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setPseudo(rs.getString("pseudo"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setStreet(rs.getString("street"));
				user.setTown(rs.getString("town"));
				user.setZipCode(rs.getString("zipCode"));
				user.setCredit(rs.getInt("credit"));
				user.setIsAdmin(rs.getBoolean("isAdmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
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
