package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IRiderDAO;
import dst.ass1.jpa.model.IDriver;
import dst.ass1.jpa.model.IRider;
import dst.ass1.jpa.model.impl.Driver;
import dst.ass1.jpa.model.impl.Rider;
import dst.ass1.jpa.model.impl.Trip;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiderDAO implements IRiderDAO {



        private EntityManager em;
        public RiderDAO(EntityManager em)
        {
            this.em = em;
        }

        @Override
    public IRider findById(Long id) {
            return (IRider)em.unwrap(Session.class).get(Rider.class,id);
    }


    @Override
    public List<IRider> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from Rider t");
        return query.getResultList();
    }





    /**
     * Finds the list of riders who have no trips within the specified date range.
     * The date range is not optional.
     *
     * @param start the lower bound of the date range
     * @param end   the upper bound of the date range
     * @return a list of riders with no trips
     * @throws IllegalArgumentException in case either start or end is null.
     */
    @Override
    public List<IRider> findRidersWithNoTrips(Date start, Date end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("The start and end dates must be given as a parameter.");
        }

        // Create a query to select all riders
        Query query = em.unwrap(Session.class).createQuery("SELECT r FROM Rider r");

        // Execute the query and get the list of riders
        List<IRider> allRiders = query.getResultList();

        // Filter out riders with no trips within the date range
        List<IRider> ridersWithNoTrips = new ArrayList<>();
        for (IRider rider : allRiders) {
            // Query to check if the rider has any trips between start and end dates
            Query tripQuery = em.unwrap(Session.class).createQuery(
                    "SELECT t FROM Trip t WHERE t.rider = :rider AND t.created >= :start AND t.created <= :end"
            );
            tripQuery.setParameter("rider", rider);
            tripQuery.setParameter("start", start);
            tripQuery.setParameter("end", end);

            List<Trip> trips = tripQuery.getResultList();
            if (trips.isEmpty()) {
                ridersWithNoTrips.add(rider);
            }
        }

        return ridersWithNoTrips;
    }

    /**
     * Returns the rider associated with the given email. Returns null if the email does not exist.
     *
     * @param email the email address
     * @return the rider or null
     */
    @Override
    public IRider findByEmail(String email) {
      
            Query query = em.unwrap(Session.class).createQuery(
                    "SELECT r FROM Rider r WHERE r.email = :email");
            query.setParameter("email", email);

            try {
                return (IRider) query.getSingleResult();
            } catch (NoResultException e) {
                // Email not found, return null
                return null;
            }
        }


}
