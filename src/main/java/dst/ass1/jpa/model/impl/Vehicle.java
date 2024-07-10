package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.DefaultListener;
import dst.ass1.jpa.model.IVehicle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
@EntityListeners({DefaultListener.class})

public class Vehicle  implements IVehicle, Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(unique = true)

    private String license;
    private String color;
    private String type;
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
    this.id = id;
    }

    @Override
    public String getLicense() {
        return this.license;
    }

    @Override
    public void setLicense(String license) {
    this.license=license;
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setColor(String color) {
    this.color=color;

    }

    @Override
    public String getType() {
        return this.type;
    }
    @Override
    public void setType(String type) {
    this.type=type;
    }
}
