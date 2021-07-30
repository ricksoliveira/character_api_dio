package one.digital.innovation.characterapi.repository;

import one.digital.innovation.characterapi.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
