package one.digital.innovation.characterapi.repository;

import one.digital.innovation.characterapi.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository extends JpaRepository<Champion, Long> {
}
