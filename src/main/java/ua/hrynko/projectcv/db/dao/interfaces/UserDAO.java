package ua.hrynko.projectcv.db.dao.interfaces;

import ua.hrynko.projectcv.db.models.Users;


import java.util.List;

public interface UserDAO extends AbstractDAO<Users> {

    void addClientToUsersDb(String login, String password, String firstname, String lastname);

    void addAdminToUsersDb(String login, String password, String firstName, String lastName);

    Users findUserByLogin(String login);

    List<Users> findAllUsers();
}
