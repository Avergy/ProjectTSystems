package services.implementations;

import dao.implementations.RoleDaoImpl;
import dao.interfaces.RoleDao;
import entity.Role;
import services.interfaces.RoleService;


public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();


    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role readRole(long id) {
        return (Role) roleDao.findById(id);
    }
}
