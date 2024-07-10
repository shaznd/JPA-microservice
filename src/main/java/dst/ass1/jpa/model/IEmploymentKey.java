package dst.ass1.jpa.model;


import javax.persistence.Transient;

public interface IEmploymentKey {

    IDriver getDriver();

    void setDriver(IDriver driver);

    IOrganization getOrganization();

    void setOrganization(IOrganization organization);
}
