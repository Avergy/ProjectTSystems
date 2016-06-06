package dao.implementations;

import dao.interfaces.RoleDao;
import entity.Role;


/**
 * Created by Siry on 05.06.2016.
 */
public class RoleDaoImpl extends AbstractGeneralDao implements RoleDao {

    public RoleDaoImpl() {
        super();
        setEntityClass(Role.class);
    }

}
