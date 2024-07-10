package dst.ass1.jpa.listener;

import dst.ass1.jpa.model.impl.Trip;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class TripListener {
    @PrePersist
    public void prePersist(Trip trip) {
        trip.setUpdated(new Date(Long.MAX_VALUE));
        trip.setCreated(new Date(Long.MAX_VALUE));
    }

    @PreUpdate
    public void preUpdate(Trip trip) {
        trip.setUpdated(new Date(Long.MAX_VALUE));
    }

}

