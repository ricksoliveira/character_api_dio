package one.digital.innovation.characterapi.repository;

import one.digital.innovation.characterapi.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>This interface is a repository which has many of basic spring boot methods</p>
 * <p>including save, delete, getById.</p>
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
