package AlwaysSpring.Heritage.Service;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Repository.HeritageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HeritageService {
    private final HeritageRepository heritageRepository;

    public void save(CulturalHeritage heritage) {
        heritageRepository.save(heritage);
    }

    public CulturalHeritage findOne(Long id) {
        return heritageRepository.findOne(id);
    }

    public List<CulturalHeritage> findAll() {
        return heritageRepository.findAll();
    }

    public List<CulturalHeritage> findByName(String name) {
        return heritageRepository.findByName(name);
    }

    public List<CulturalHeritage> getTopTen() {
        return heritageRepository.getTopTen();
    }

    public void plusSearchCount(Long id) {
        heritageRepository.updateHeritageCount(id);
    }

}
