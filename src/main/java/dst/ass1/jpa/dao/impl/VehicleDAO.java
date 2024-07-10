package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IVehicleDAO;
import dst.ass1.jpa.model.IVehicle;
import dst.ass1.jpa.model.impl.Vehicle;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VehicleDAO implements IVehicleDAO {


    private EntityManager em;
    public VehicleDAO(EntityManager em)
    {
        this.em = em;
    }
    @Override
    public IVehicle findById(Long id) {
        return (IVehicle)em.unwrap(Session.class).get(Vehicle.class,id);

    }

    @Override
    public List<IVehicle> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from Vehicle t");
        return query.getResultList();
    }
}
