package db.ai.digitalbridgeai.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Data
@Table(name = "pazls")
public class Pazl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;
    @Column(name = "pazl_name")
    private String pazlName;

    @OneToMany(mappedBy = "pazl")
    private List<Photo> photos;
    @OneToMany(mappedBy = "pazl")
    private List<Audio> audio;
    @OneToMany(mappedBy = "pazl")
    private List<Test> tests;
    @OneToMany(mappedBy = "pazl")
    private List<Translate> translates;
}
