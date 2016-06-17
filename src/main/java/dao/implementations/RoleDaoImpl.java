package dao.implementations;

import dao.interfaces.RoleDao;
import entity.Role;



public class RoleDaoImpl extends AbstractGenericDao implements RoleDao {

    public RoleDaoImpl() {
        super();
        setEntityClass(Role.class);
    }

}
