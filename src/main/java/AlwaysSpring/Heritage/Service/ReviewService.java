package AlwaysSpring.Heritage.Service;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Domain.Review;
import AlwaysSpring.Heritage.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void save(Review review) {
        reviewRepository.save(review);
    }

    public void remove(Long id) {
        reviewRepository.remove(id);
    }

    public List<Review> findByHeritage(Long heritage_id) {
        return reviewRepository.findByHeritage(heritage_id);
    }
}
