package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IEmploymentDAO;
import dst.ass1.jpa.model.IEmployment;
import dst.ass1.jpa.model.impl.Employment;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmploymentDAO implements IEmploymentDAO {
    private EntityManager em;
    public EmploymentDAO(EntityManager em)
    {
        this.em=em;
    }

    @Override
    public IEmployment findById(Long id) {
        return (IEmployment)em.unwrap(Session.class).get(Employment.class,id);

    }

    @Override
    public List<IEmployment> findAll() {
         Query query = (Query) em.unwrap(Session.class).createQuery("Select t from Employment t");
        return query.getResultList();
    }
}
