package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ITripDAO;
import dst.ass1.jpa.model.ITrip;
import dst.ass1.jpa.model.TripState;
import dst.ass1.jpa.model.impl.Trip;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TripDAO implements ITripDAO {

    private EntityManager em;
    public TripDAO(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public ITrip findById(Long id) {
        return (ITrip)em.unwrap(Session.class).get(Trip.class,id);
    }

    @Override
    public List<ITrip> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from Trip t");
        return query.getResultList();
    }

   /**
            * Finds a list of trips with the specified trip state.
            *
            * @param state The trip state to filter by.
     * @return A list of ITrip objects with the specified trip state.
            * @throws IllegalArgumentException if state is null
            */
    @Override
    public List<ITrip> findByStatus(TripState state) {
        List<ITrip> allTrips = findAll();
        List<ITrip> filteredTrips = new ArrayList<>();

        for (ITrip trip: allTrips){

            if (trip.getState() == state ) { filteredTrips.add(trip);  }
        }
        if (filteredTrips.isEmpty()){  return null;}
        else return filteredTrips;



    }
}
