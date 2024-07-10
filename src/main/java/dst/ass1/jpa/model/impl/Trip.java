package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.listener.TripListener;
import dst.ass1.jpa.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static dst.ass1.jpa.util.Constants.*;

@Entity
@Table
@EntityListeners({TripListener.class, DefaultListener.class})
public class Trip implements ITrip, Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date created;
    private Date updated;

    @Enumerated(EnumType.STRING)
    private TripState state;

    @OneToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
    @JoinColumn(name = I_PICKUP, referencedColumnName = "id", nullable = false)
    private ILocation pickup;

    @OneToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
    @JoinColumn(name = I_DESTINATION, referencedColumnName = "id", nullable = false)
    private ILocation destination;

    @ManyToMany(targetEntity = Location.class, cascade = CascadeType.ALL)
    @JoinTable(name = J_TRIP_LOCATION,
            joinColumns = @JoinColumn(name = I_TRIP, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = I_STOPS, referencedColumnName = "id"))
    private Collection<ILocation> stops= new ArrayList<>();

    @OneToOne(targetEntity = TripInfo.class, mappedBy = M_TRIP_INFO_TRIP)
    @JoinColumn(name = I_TRIP_INFO , referencedColumnName= "id",nullable = false)
    private ITripInfo tripInfo;

    @OneToOne(targetEntity = Match.class, mappedBy = M_MATCH_TRIP)
    @JoinColumn(name = I_MATCH, referencedColumnName = "id")
    private IMatch match;

    @ManyToOne(targetEntity = Rider.class)
    @JoinColumn(name = I_RIDER, referencedColumnName = "id")
    private IRider rider;


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
      this.id =id;
    }

    @Override
    public Date getCreated() {
        return this.created;
    }

    @Override
    public void setCreated(Date created) {
       this.created=created;
    }

    @Override
    public Date getUpdated() {
        return this.updated;
    }

    @Override
    public void setUpdated(Date updated) {
     this.updated= updated;
    }

    @Override
    public TripState getState() {
        return this.state;
    }

    @Override
    public void setState(TripState state) {
       this.state = state;
    }

    @Override
    public ILocation getPickup() {
        return this.pickup;
    }

    @Override
    public void setPickup(ILocation pickup) {
          this.pickup=pickup;
    }

    @Override
    public ILocation getDestination() {
        return this.destination;
    }

    @Override
    public void setDestination(ILocation destination) {
           this.destination=destination;
    }

    @Override
    public Collection<ILocation> getStops() {
        return this.stops;
    }

    @Override
    public void setStops(Collection<ILocation> stops) {
       this.stops=stops;
    }

    @Override
    public void addStop(ILocation stop) {
     this.stops.add(stop);
    }

    @Override
    public ITripInfo getTripInfo() {
        return this.tripInfo;
    }

    @Override
    public void setTripInfo(ITripInfo tripInfo) {
     this.tripInfo=tripInfo;
    }

    @Override
    public IMatch getMatch() {
        return this.match;
    }

    @Override
    public void setMatch(IMatch match) {
       this.match=match;
    }

    @Override
    public IRider getRider() {
        return this.rider;
    }

    @Override
    public void setRider(IRider rider) {
       this.rider=rider;
    }
}
