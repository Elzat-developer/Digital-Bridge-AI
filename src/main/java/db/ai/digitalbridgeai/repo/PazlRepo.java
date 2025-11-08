package db.ai.digitalbridgeai.repo;

import db.ai.digitalbridgeai.entity.Pazl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PazlRepo extends JpaRepository<Pazl, Integer> {
    Pazl findById(int pazlId);
}
