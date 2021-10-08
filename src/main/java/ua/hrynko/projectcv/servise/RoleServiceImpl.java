package ua.hrynko.projectcv.servise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hrynko.projectcv.db.dao.MySqlRolesDAO;
import ua.hrynko.projectcv.db.models.Roles;
import ua.hrynko.projectcv.servise.interfaces.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    MySqlRolesDAO mySqlRolesDAO;

    @Override
    public Roles findRoleByName(String roleName) {
        return mySqlRolesDAO.findRoleByName(roleName);
    }


    @Override
    public void save(Roles obj) {
        mySqlRolesDAO.save(obj);
    }

    @Override
    public void update(Roles obj) {
        mySqlRolesDAO.update(obj);
    }

    @Override
    public void delete(Roles obj) {
        mySqlRolesDAO.delete(obj);
    }


    @Override
    public Roles getById(int id) {return mySqlRolesDAO.getById(id);}

    @Override
    public List<Roles> getAll() {
        return mySqlRolesDAO.getAll();
    }
}
