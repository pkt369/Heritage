package AlwaysSpring.Heritage.Repository;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;

    public void save(Review review) {
        em.persist(review);
    }

    public List<Review> findByHeritage(Long heritage_id) {
        return em.createQuery("select r from Review r join fetch r.heritage h where h.id = :id", Review.class)
                .setParameter("id", heritage_id)
                .getResultList();
    }

    public void remove(Long id) {
        Review review = em.find(Review.class, id);
        em.remove(review);
    }
}
