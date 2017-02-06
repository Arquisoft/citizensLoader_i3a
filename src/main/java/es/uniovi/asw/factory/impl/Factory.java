package es.uniovi.asw.factory.impl;

import es.uniovi.asw.factory.IFactory;

public class Factory implements IFactory {
	private DAOFactory daof;
	private PersonFactory pf;
	@Override
	public DAOFactory getDAO() {
		return daof = (daof == null ? new DAOFactory() : daof);
	}

	@Override
	public PersonFactory getPerson() {
		return pf = (pf == null ? new PersonFactory() : pf);
	}

}
