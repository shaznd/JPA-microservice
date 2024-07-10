package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMatchDAO;
import dst.ass1.jpa.model.IMatch;
import dst.ass1.jpa.model.impl.Match;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MatchDAO implements IMatchDAO {
    private EntityManager em;
    public MatchDAO(EntityManager em)
    {
        this.em = em;
    }
    @Override
    public IMatch findById(Long id) {
        return (IMatch)em.unwrap(Session.class).get(Match.class,id);
    }

    @Override
    public List<IMatch> findAll() {
        Query query = em.unwrap(Session.class).createQuery("Select t from Match t");
        return query.getResultList();
    }
}
