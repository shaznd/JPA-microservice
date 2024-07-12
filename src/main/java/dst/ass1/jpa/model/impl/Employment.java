package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.*;
import org.hibernate.annotations.Target;
//import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static dst.ass1.jpa.util.Constants.I_DRIVER;
import static dst.ass1.jpa.util.Constants.I_ORGANIZATION;
@Entity
@Table
@EntityListeners({DefaultListener.class})
@AssociationOverrides({
        @AssociationOverride(name = "id.organization",
                joinColumns = @JoinColumn(name = I_ORGANIZATION, referencedColumnName = "id")),
        @AssociationOverride(name = "id.driver",
                joinColumns = @JoinColumn(name = I_DRIVER, referencedColumnName = "id"))
})


public class Employment implements IEmployment, Serializable {
    private static final long serialVersionUID = 1L;


    @EmbeddedId

    @Target(EmploymentKey.class)
    private IEmploymentKey id ;
    private Date since;
    private Boolean active;


    @Override
    public IEmploymentKey getId() {
        return this.id;
    }

    @Override
    public void setId(IEmploymentKey employmentKey) {
      this.id= employmentKey ;
    }

    @Override
    public Date getSince() {
        return this.since;
    }

    @Override
    public void setSince(Date since) {
    this.since=since;
    }

    @Override
    public Boolean isActive() {
        return active;
    }

    @Override
    public void setActive(Boolean active) {
      this.active=active;
    }



    @Transient
    public IDriver getDriver() {
        return this.id.getDriver();
    }


    public void setDriver(IDriver driver) {

        this.id.setDriver(driver);
    }

    @Transient
    public IOrganization getOrganization() {
        return this.id.getOrganization();
    }

    public void setOrganization(IOrganization organization) {

        this.id.setOrganization(organization);
    }

}
