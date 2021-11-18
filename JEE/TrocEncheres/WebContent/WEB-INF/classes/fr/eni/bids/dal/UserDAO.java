package fr.eni.bids.dal;

import java.util.List;

import fr.eni.bids.bo.User;

public interface UserDAO extends DAO<User> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.DAO#getById(java.lang.Integer)
	 */
	@Override
	default User getById(Integer id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.DAO#getAll()
	 */
	@Override
	default List<User> getAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.DAO#insert(java.lang.Object)
	 */
	@Override
	default void insert(User data) throws DALException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.DAO#update(java.lang.Object)
	 */
	@Override
	default void update(User data) throws DALException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.eni.bids.dal.DAO#delete(java.lang.Object)
	 */
	@Override
	default void delete(User obj) throws DALException {
		// TODO Auto-generated method stub

	}

}
