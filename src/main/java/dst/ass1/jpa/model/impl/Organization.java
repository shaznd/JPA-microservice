package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IEmployment;
import dst.ass1.jpa.model.IOrganization;
import dst.ass1.jpa.model.IVehicle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import static dst.ass1.jpa.util.Constants.*;

@Entity
@Table
@EntityListeners({DefaultListener.class})
public class Organization implements IOrganization, Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(targetEntity = Organization.class)
    @JoinTable(name = J_ORGANIZATION_PARTS,
            joinColumns = @JoinColumn(name = I_ORGANIZATION_PARTS, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = I_ORGANIZATION_PART_OF, referencedColumnName = "id"))
    private Collection<IOrganization> parts= new ArrayList<>();

    @ManyToMany(targetEntity = Organization.class, mappedBy = M_ORGANIZATION_PARTS)
    private Collection<IOrganization> partOf= new ArrayList<>();

    @OneToMany(targetEntity = Employment.class,
            mappedBy = "id.organization")
    private Collection<IEmployment> employments= new ArrayList<>();

    @ManyToMany(targetEntity = Vehicle.class)
    @JoinTable(name = J_ORGANIZATION_VEHICLE,
            joinColumns = @JoinColumn(name = I_ORGANIZATION, referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = I_VEHICLES, referencedColumnName = "id"))
    private Collection<IVehicle> vehicles= new ArrayList<>();


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
      this.id= id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
     this.name = name;
    }

    @Override
    public Collection<IOrganization> getParts() {
        return parts;
    }

    @Override
    public void setParts(Collection<IOrganization> parts) {
    this.parts=parts;
    }

    @Override
    public void addPart(IOrganization part) {
        this.parts.add(part);

    }

    @Override
    public Collection<IOrganization> getPartOf() {
        return this.partOf;
    }

    @Override
    public void setPartOf(Collection<IOrganization> partOf) {
      this.partOf=partOf;
    }

    @Override
    public void addPartOf(IOrganization partOf) {
      this.partOf.add(partOf);
    }

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
    public Collection<IVehicle> getVehicles() {
        return this.vehicles;
    }

    @Override
    public void setVehicles(Collection<IVehicle> vehicles) {
    this.vehicles=vehicles;
    }

    @Override
    public void addVehicle(IVehicle vehicle) {
        this.vehicles.add(vehicle);

    }
}
