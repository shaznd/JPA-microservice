package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IPlatformUser;

import javax.persistence.*;

@MappedSuperclass
public abstract class PlatformUser implements IPlatformUser {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String tel;
    private Double avgRating;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
    public String getTel() {
        return this.tel;
    }

    @Override
    public void setTel(String tel) {
     this.tel = tel;
    }

    @Override
    public Double getAvgRating() {
        return this.avgRating;
    }

    @Override
    public void setAvgRating(Double avgRating) {
    this.avgRating= avgRating;
    }
}
