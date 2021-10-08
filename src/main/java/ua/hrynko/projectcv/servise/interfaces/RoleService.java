package ua.hrynko.projectcv.servise.interfaces;


import ua.hrynko.projectcv.db.models.Roles;


public interface RoleService extends Service<Roles> {
    Roles findRoleByName(String roleName);

    }
