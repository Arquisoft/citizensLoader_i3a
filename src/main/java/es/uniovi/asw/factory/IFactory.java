package es.uniovi.asw.factory;

import es.uniovi.asw.factory.impl.DAOFactory;
import es.uniovi.asw.factory.impl.PersonFactory;

public interface IFactory {
	DAOFactory getDAO();
	PersonFactory getPerson();
}
