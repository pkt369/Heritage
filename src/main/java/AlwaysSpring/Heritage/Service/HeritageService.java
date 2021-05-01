package AlwaysSpring.Heritage.Service;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Repository.HeritageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeritageService {
    private final HeritageRepository heritageRepository;

    public int save(CulturalHeritage heritage) {
        return heritageRepository.save(heritage);
    }

    public CulturalHeritage findOne(int id) {
        return heritageRepository.findOne(id);
    }

    public List<CulturalHeritage> findAll() {
        return heritageRepository.findAll();
    }

    public CulturalHeritage findByName(String name) {
        return heritageRepository.findByName(name);
    }

}
