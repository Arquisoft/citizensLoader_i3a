package Factory;

import Factory.impl.DAOFactory;
import Factory.impl.PersonFactory;

public interface IFactory {
	DAOFactory getDAO();
	PersonFactory getPerson();
}
