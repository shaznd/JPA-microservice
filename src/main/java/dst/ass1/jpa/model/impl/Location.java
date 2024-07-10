package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.ILocation;

import javax.persistence.*;
import java.io.Serializable;

import static dst.ass1.jpa.util.Constants.Q_REACHED_LOCATIONS;

@Entity
@Table
@EntityListeners({DefaultListener.class})
@NamedQueries({
        @NamedQuery(name=Q_REACHED_LOCATIONS, query = "SELECT t FROM Trip t WHERE t.state= :state")
})
public class Location implements ILocation, Serializable {

    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String name;
    private Long locationId;
    


    @Override
    public Long getId() {
        return this.id ;
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
    this.name = name;
    }

    @Override
    public Long getLocationId() {
        return this.locationId;
    }

    @Override
    public void setLocationId(Long locationId) {
    this.locationId=locationId;
    }
}
