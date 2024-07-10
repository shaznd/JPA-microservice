package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.ITrip;
import dst.ass1.jpa.model.ITripInfo;
import dst.ass1.jpa.model.ITripReceipt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static dst.ass1.jpa.util.Constants.*;


@Entity
@Table
@EntityListeners({DefaultListener.class})
public class TripInfo implements ITripInfo, Serializable {
    private static final long serialVersionUID = -1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date completed;
    private Double distance;
    @Embedded
    private Money total;
    private Integer driverRating;
    private Integer riderRating;

    @OneToOne(targetEntity = Trip.class)
    @JoinColumn(name = I_TRIP, referencedColumnName = M_ID,nullable = false)
    private ITrip trip;

    @OneToOne(targetEntity = TripReceipt.class)
    @JoinColumn(name = I_TRIP_RECEIPT, referencedColumnName = M_ID)
    private ITripReceipt receipt;
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
    this.id=id;
    }

    @Override
    public Date getCompleted() {
        return this.completed;
    }

    @Override
    public void setCompleted(Date date) {
     this.completed=date;
    }

    @Override
    public Double getDistance() {
        return this.distance;
    }

    @Override
    public void setDistance(Double distance) {
      this.distance=distance;
    }

    @Override
    public Integer getDriverRating() {
        return this.driverRating;
    }

    @Override
    public void setDriverRating(Integer driverRating) {
      this.driverRating=driverRating;
    }

    @Override
    public Integer getRiderRating() {
        return this.riderRating;
    }

    @Override
    public void setRiderRating(Integer riderRating) {
      this.riderRating=riderRating;
    }

    @Override
    public ITrip getTrip() {
        return this.trip;
    }

    @Override
    public void setTrip(ITrip trip) {
     this.trip=trip;
    }

    @Override
    public ITripReceipt getReceipt() {
        return this.receipt;
    }

    @Override
    public void setReceipt(ITripReceipt receipt) {
        this.receipt=receipt;
    }
}
