package one.digital.innovation.characterapi.repository;

import one.digital.innovation.characterapi.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
