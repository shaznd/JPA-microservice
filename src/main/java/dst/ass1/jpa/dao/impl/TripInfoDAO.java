package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ITripInfoDAO;
import dst.ass1.jpa.model.ITripInfo;
import dst.ass1.jpa.model.impl.TripInfo;
import dst.ass1.jpa.util.TupleResult;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripInfoDAO implements ITripInfoDAO {


    private EntityManager em;
    public TripInfoDAO(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public ITripInfo findById(Long id) {
        return (ITripInfo)em.unwrap(Session.class).get(TripInfo.class,id);
    }

    @Override
    public List<ITripInfo> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from TripInfo t");
        return query.getResultList();

    }
    /**
     * Finds the average rating for each rider.
     * Result is sorted descending by the calculated rating.
     *
     * @return a list of TupleResult objects containing the rider's ID and their average rating
     */
    @Override
    public List<TupleResult<Long, Double>> findRidersAverageRating() {
        // Step 1: Retrieve all TripInfo records
        List<ITripInfo> trips = findAll();

        // Step 2: Group by riderId
        Map<Long, List<ITripInfo>> tripsByRider = trips.stream()
                .collect(Collectors.groupingBy(ITripInfo::getId));

        // Step 3: Calculate the average rating for each rider
        List<TupleResult<Long, Double>> averageRatings = new ArrayList<>();
        for (Map.Entry<Long, List<ITripInfo>> entry : tripsByRider.entrySet()) {
            Long riderId = entry.getKey();
            List<ITripInfo> riderTrips = entry.getValue();

            double averageRating = riderTrips.stream()
                    .mapToDouble(ITripInfo::getRiderRating)
                    .average()
                    .orElse(0.0);

            averageRatings.add(new TupleResult<>(riderId, averageRating));
        }

        // Step 4: Sort the results by the average rating in descending order
        averageRatings.sort((a, b) -> Double.compare(b.getSecond(), a.getSecond()));

        return averageRatings;
    }
}
