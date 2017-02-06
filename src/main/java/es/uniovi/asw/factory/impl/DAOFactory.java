package es.uniovi.asw.factory.impl;

import es.uniovi.asw.dao.UserDAO;
import es.uniovi.asw.factory.IDAOFactory;

public class DAOFactory implements IDAOFactory {
	private UserDAO udao;
	@Override
	public UserDAO getUserDAO() {
		return udao = (udao == null ? new UserDAO() : udao);
	}

}
