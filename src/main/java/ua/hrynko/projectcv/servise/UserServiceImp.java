package ua.hrynko.projectcv.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hrynko.projectcv.db.dao.MySqlUsersDAO;
import ua.hrynko.projectcv.db.models.Users;
import ua.hrynko.projectcv.servise.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private MySqlUsersDAO mySqlUsersDAO;

    @Override
    public Users findUserByLogin(String login) {

        return mySqlUsersDAO.findUserByLogin(login);
    }

    @Override
    public void addClientToUsersDb(String login, String password, String firstName, String lastName) {
        mySqlUsersDAO.addClientToUsersDb(login, password, firstName, lastName);
    }

    @Override
    public void addAdminToUsersDb(String login, String password, String firstName, String lastName) {
        mySqlUsersDAO.addAdminToUsersDb(login, password, firstName, lastName);
    }


    @Transactional
    @Override
    public void save(Users obj) {
        mySqlUsersDAO.save(obj);
    }

    @Transactional
    @Override
    public void update(Users obj) {
        mySqlUsersDAO.update(obj);
    }

    @Transactional
    @Override
    public void delete(Users obj) {mySqlUsersDAO.delete(obj);
    }

    @Override
    public Users getById(int id) {return mySqlUsersDAO.getById(id);}

    @Transactional(readOnly = true)
    @Override
    public List<Users> getAll() {
        return mySqlUsersDAO.getAll();
    }


    }
