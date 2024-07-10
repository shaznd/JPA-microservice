package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IPaymentInfo;
import dst.ass1.jpa.model.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@EntityListeners({DefaultListener.class})
public class PaymentInfo implements IPaymentInfo, Serializable {
    private static final long serialVersionUID = -1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private PaymentMethod method;
    private boolean preferred;



    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
     this.id=id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
     this.name=name;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.method;
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
       this.method=paymentMethod;
    }

    @Override
    public Boolean isPreferred() {
        return this.preferred;
    }

    @Override
    public void setPreferred(Boolean preferred) {
       this.preferred=preferred;
    }
}
