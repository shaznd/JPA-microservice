package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IMoney;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;


@Embeddable
public class Money implements IMoney {


    private String currency;
    private BigDecimal currenyValue;


    @Override
    public String getCurrency() {
        return this.currency;
    }

    @Override
    public void setCurrency(String currency) {
    this.currency= currency;
    }

    @Override
    public BigDecimal getCurrencyValue() {
        return this.currenyValue;
    }

    @Override
    public void setCurrencyValue(BigDecimal currencyValue) {
      this.currenyValue= currencyValue;
    }
}
