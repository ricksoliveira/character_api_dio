package one.digital.innovation.characterapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.characterapi.enums.Specialization;

import javax.persistence.*;
import java.util.List;

/**
 * <p>This class represents a table of the database</p>
 * <p>and its attributes are the tables columns.</p>
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long level;

    @Column(nullable = false)
    private Specialization charSpec;

    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE})
    private List<Profession> professions;

    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE})
    private List<Skill> skills;

}
