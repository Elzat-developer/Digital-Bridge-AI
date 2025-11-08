package db.ai.digitalbridgeai.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Data
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;
    @Column(name = "photo_url")
    private String photoURL;
    @Column(name = "exercise")
    private String exercise;
    @Column(name = "example")
    private String example;
    @Column(name = "result")
    private String result;
    @ManyToOne
    @JoinColumn(name = "pazls_id",referencedColumnName = "id")
    private Pazl pazl;
}
