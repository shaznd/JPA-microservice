package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IDriver;
import dst.ass1.jpa.model.IEmployment;
import dst.ass1.jpa.model.IEmploymentKey;
import dst.ass1.jpa.model.IOrganization;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmploymentKey implements IEmploymentKey, Serializable {

     private static final long serialVersionUID = -1L;


    @ManyToOne(targetEntity = Driver.class ,optional = false)
    private IDriver driver;
    @ManyToOne(targetEntity = Organization.class,optional = false)
    private IOrganization organization;


    public EmploymentKey() {
    }


    @Override
    public IDriver getDriver() {
        return this.driver;
    }

    @Override
    public void setDriver(IDriver driver) {
        this.driver = driver;
    }

    @Override
    public IOrganization getOrganization() {
        return this.organization;
    }

    @Override
    public void setOrganization(IOrganization organization) {

        this.organization = organization;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmploymentKey that = (EmploymentKey) o;
        return Objects.equals(getDriver(), that.getDriver()) &&
                Objects.equals(getOrganization(), that.getOrganization());
    }

    @Override
    public int hashCode() {
//        return Objects.hash(getDriver(), getOrganization());
        int result = getDriver() != null ? getDriver().hashCode() : 0;
        result = 31 * result + (getOrganization() != null ? getOrganization().hashCode() : 0);
        return result;
    }

}
