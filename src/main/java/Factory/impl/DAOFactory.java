package Factory.impl;

import Factory.IDAOFactory;
import dao.UserDAO;

public class DAOFactory implements IDAOFactory {
	private UserDAO udao;
	@Override
	public UserDAO getUserDAO() {
		return udao = (udao == null ? new UserDAO() : udao);
	}

}
