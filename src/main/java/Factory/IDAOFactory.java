package Factory;

import dao.UserDAO;

public interface IDAOFactory {
	UserDAO getUserDAO();
}
