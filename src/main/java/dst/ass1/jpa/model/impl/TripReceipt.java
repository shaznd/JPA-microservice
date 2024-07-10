package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IMoney;
import dst.ass1.jpa.model.IPaymentInfo;
import dst.ass1.jpa.model.ITripInfo;
import dst.ass1.jpa.model.ITripReceipt;

import javax.persistence.*;
import java.io.Serializable;

import static dst.ass1.jpa.util.Constants.*;

@Entity
@Table
@EntityListeners({DefaultListener.class})
public class TripReceipt implements ITripReceipt, Serializable {
    private static final long serialVersionUID = -1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Embedded
    private IMoney total;
    @Embedded
    private IMoney tip;
    private boolean paid;

    @OneToOne(targetEntity = TripInfo.class)
    @JoinColumn(name = I_TRIP_INFO, referencedColumnName = M_ID)
     private ITripInfo tripInfo;


    @ManyToOne(targetEntity = PaymentInfo.class)
    @JoinColumn(name = I_PAYMENT_INFO, referencedColumnName = "id")
    private IPaymentInfo paymentInfo;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
     this.id=id;
    }

    @Override
    public IMoney getTotal() {
        return this.total;
    }

    @Override
    public void setTotal(IMoney total) {
        this.total=total;
    }

    @Override
    public IMoney getTip() {
        return this.tip;
    }

    @Override
    public void setTip(IMoney tip) {
            this.tip=tip;
    }

    @Override
    public boolean isPaid() {
        return this.paid;
    }

    @Override
    public void setPaid(boolean paid) {
     this.paid=paid;
    }

    @Override
    public IPaymentInfo getPaymentInfo() {
        return this.paymentInfo;
    }

    @Override
    public void setPaymentInfo(IPaymentInfo paymentInfo) {
        this.paymentInfo =paymentInfo;
    }

    @Override
    public ITripInfo getTripInfo() {
        return this.tripInfo;
    }

    @Override
    public void setTripInfo(ITripInfo tripInfo) {
        this.tripInfo=tripInfo;
    }
}
