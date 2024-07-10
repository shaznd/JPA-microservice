package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static dst.ass1.jpa.util.Constants.*;

@Entity
@Table
@EntityListeners({DefaultListener.class})
public class Match implements IMatch, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Date date;

    @Embedded
    private IMoney fare;

    @OneToOne(targetEntity = Trip.class)
    @JoinColumn(name = I_TRIP, referencedColumnName = "id")
    private ITrip trip;

    @ManyToOne(targetEntity = Vehicle.class)
    @JoinColumn(name = I_VEHICLE, referencedColumnName = "id")
    private IVehicle vehicle;

    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(name = I_DRIVER, referencedColumnName = "id")
    private IDriver driver;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
     this.id=id;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public void setDate(Date date) {
    this.date=date;
    }

    @Override
    public IMoney getFare() {
        return this.fare;
    }

    @Override
    public void setFare(IMoney money) {
     this.fare=money;
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
    public IVehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public void setVehicle(IVehicle vehicle) {
       this.vehicle=vehicle;
    }

    @Override
    public IDriver getDriver() {
        return this.driver;
    }

    @Override
    public void setDriver(IDriver driver) {
       this.driver=driver;
    }
}
