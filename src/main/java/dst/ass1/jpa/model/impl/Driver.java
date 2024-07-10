package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IDriver;
import dst.ass1.jpa.model.IEmployment;
import dst.ass1.jpa.model.IVehicle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import static dst.ass1.jpa.util.Constants.I_VEHICLE;
import static dst.ass1.jpa.util.Constants.M_ID;
import static javax.servlet.jsp.tagext.TagAttributeInfo.ID;


@Entity
@Table
@EntityListeners({DefaultListener.class})
public class Driver extends PlatformUser implements IDriver, Serializable {

    private static final long serialVersionUID = -1L;




    @ManyToMany(targetEntity = Employment.class)
    private Collection<IEmployment> employments= new ArrayList<>();

    @ManyToOne(targetEntity = Vehicle.class)
    @JoinColumn(name = I_VEHICLE, referencedColumnName = M_ID, nullable = false)
    private IVehicle vehicle;


    @Override
    public Collection<IEmployment> getEmployments() {
        return this.employments;
    }

    @Override
    public void setEmployments(Collection<IEmployment> employments) {

        this.employments=employments;
    }

    @Override
    public void addEmployment(IEmployment employment) {
      this.employments.add(employment);
    }

    @Override
    public IVehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public void setVehicle(IVehicle vehicle) {
      this.vehicle=vehicle;
    }


    
}
