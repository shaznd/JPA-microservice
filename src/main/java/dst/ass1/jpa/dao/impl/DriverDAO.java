package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IDriverDAO;
import dst.ass1.jpa.model.IDriver;
import dst.ass1.jpa.model.impl.Driver;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DriverDAO implements IDriverDAO {

    private EntityManager em;
    public DriverDAO(EntityManager em)
    {
        this.em = em;
    }
    @Override
    public IDriver findById(Long id) {
        return (IDriver)em.unwrap(Session.class).get(Driver.class,id);
    }

    @Override
    public List<IDriver> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select d from Driver d");
        return query.getResultList();
    }
}
