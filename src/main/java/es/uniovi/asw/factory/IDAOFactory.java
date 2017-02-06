package es.uniovi.asw.factory;

import es.uniovi.asw.dao.UserDAO;

public interface IDAOFactory {
	UserDAO getUserDAO();
}
