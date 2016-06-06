package dao.implementations;

import dao.interfaces.PaymentDao;
import entity.Payment;

/**
 * Created by Siry on 02.06.2016.
 */
public class PaymentDaoImpl extends AbstractGeneralDao implements PaymentDao {

    public PaymentDaoImpl() {
        super();
        setEntityClass(Payment.class);
    }


    //public int findByStatus(String name){}
}
