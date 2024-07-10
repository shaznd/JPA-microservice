package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IOrganizationDAO;
import dst.ass1.jpa.model.IOrganization;
import dst.ass1.jpa.model.impl.Organization;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrganizationDAO implements IOrganizationDAO {

    private EntityManager em;
    public OrganizationDAO(EntityManager em)
    {
        this.em = em;
    }
    @Override
    public IOrganization findById(Long id) {
        return (IOrganization)em.unwrap(Session.class).get(Organization.class,id);
    }

    @Override
    public List<IOrganization> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from Organization t");
        return query.getResultList();
    }
}
