package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILocationDAO;
import dst.ass1.jpa.model.ILocation;
import dst.ass1.jpa.model.impl.Location;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LocationDAO implements ILocationDAO {

    private EntityManager em;
    public LocationDAO(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public ILocation findById(Long id) {
        return (ILocation)em.unwrap(Session.class).get(Location.class,id);
    }

    @Override
    public List<ILocation> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from Location t");
        return  query.getResultList();
    }
}
