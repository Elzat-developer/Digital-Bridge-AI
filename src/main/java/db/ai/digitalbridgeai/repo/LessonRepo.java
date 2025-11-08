package db.ai.digitalbridgeai.repo;

import db.ai.digitalbridgeai.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson,Integer> {
}
