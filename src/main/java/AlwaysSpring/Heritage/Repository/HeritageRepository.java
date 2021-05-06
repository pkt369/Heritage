package AlwaysSpring.Heritage.Repository;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HeritageRepository {
    private final Map<Integer, CulturalHeritage> map = new HashMap<>();
    private int id = 1;

    public int save(CulturalHeritage heritage) {
        map.put(id, heritage);
        return id++;
    }

    public CulturalHeritage findOne(int id) {
        return map.get(id);
    }

    public List<CulturalHeritage> findAll() {
        List<CulturalHeritage> list = new ArrayList<>();
        map.forEach((integer, heritage) -> list.add(heritage));
        return list;
    }

    public CulturalHeritage findByName(String name) {
        for (int i = 0; i < map.size(); i++) {
             String getName = map.get(i).getCcmaName();
            if (getName.equals(name)) {
                return map.get(i);
            }
        }
        return null;
    }

}
