package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IPaymentInfo;
import dst.ass1.jpa.model.IRider;
import dst.ass1.jpa.model.ITrip;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import static dst.ass1.jpa.util.Constants.*;


@Entity

@EntityListeners({DefaultListener.class})
@NamedQueries({
        @NamedQuery(name = Q_RIDER_BY_EMAIL, query = "SELECT rider FROM Rider rider WHERE rider.email= :email"),
})
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { M_RIDER_EMAIL, M_RIDER_NAME }) })
public class Rider extends PlatformUser implements IRider, Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double avgRating;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private byte[] password;


    @OneToMany(targetEntity = Trip.class, mappedBy = M_TRIP_RIDER)
    private Collection<ITrip> trips;


    @OneToMany(targetEntity = PaymentInfo.class)
    private Collection<IPaymentInfo> paymentInfos;




    @Override
    public Double getAvgRating() {
        return this.avgRating;
    }

    @Override
    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public byte[] getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public Collection<ITrip> getTrips() {
        return this.trips;
    }

    @Override
    public void setTrips(Collection<ITrip> trips) {
        this.trips = trips;
    }

    @Override
    public void addTrip(ITrip trip) {
        this.trips.add(trip);
    }

    @Override
    public Collection<IPaymentInfo> getPaymentInfos() {
        return this.getPaymentInfos();
    }

    @Override
    public void setPaymentInfos(Collection<IPaymentInfo> paymentInfos) {
        this.paymentInfos = paymentInfos;

    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
