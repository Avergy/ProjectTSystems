package services.implementations;

import Util.DAOsUtil;
import dao.interfaces.RoleDao;
import entity.Role;
import services.interfaces.RoleService;


public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = DAOsUtil.getRoleDao();

    public Role readRole(long id) {
        return (Role) roleDao.findById(id);
    }
}
