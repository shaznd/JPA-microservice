package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IPaymentInfoDAO;
import dst.ass1.jpa.model.IPaymentInfo;
import dst.ass1.jpa.model.impl.PaymentInfo;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PaymentInfoDAO implements IPaymentInfoDAO {

    private EntityManager em;
    public PaymentInfoDAO(EntityManager em)
    {
        this.em = em;
    }


    public Object findById(Long id) {
        return (IPaymentInfo)em.unwrap(Session.class).get(PaymentInfo.class,id);
    }


    public List findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select p from PaymentInfo p");
        return query.getResultList();
    }
}
