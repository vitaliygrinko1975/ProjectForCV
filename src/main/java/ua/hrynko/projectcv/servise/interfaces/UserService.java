package ua.hrynko.projectcv.servise.interfaces;

import ua.hrynko.projectcv.db.models.Users;

public interface UserService extends Service<Users> {
    Users findUserByLogin(String login);

    void addClientToUsersDb(String login, String password, String firstName, String lastName);

    void addAdminToUsersDb(String login, String password, String firstName, String lastName);
}



