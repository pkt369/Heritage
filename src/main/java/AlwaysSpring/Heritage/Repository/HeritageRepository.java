package AlwaysSpring.Heritage.Repository;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class HeritageRepository {

    private final EntityManager em;

    public void save(CulturalHeritage heritage) {
        em.persist(heritage);
    }

    public CulturalHeritage findOne(Long id) {
        return em.find(CulturalHeritage.class, id);
    }

    public List<CulturalHeritage> findAll() {
        return em.createQuery("select c from CulturalHeritage c", CulturalHeritage.class)
                .getResultList();
    }

    public List<CulturalHeritage> findByName(String name) {
        return em.createQuery("select c from CulturalHeritage c where c.ccbaMnm1 LIKE :name", CulturalHeritage.class)
                .setParameter("name", '%' + name + '%')
                .getResultList();
    }

    public List<CulturalHeritage> getTopTen() {
        return em.createQuery("select c from CulturalHeritage c order by c.searchCount desc", CulturalHeritage.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
    }

    public void updateHeritageCount(Long id) {
        CulturalHeritage heritage = em.find(CulturalHeritage.class, id);
        heritage.plusSearchCount();
    }

}
