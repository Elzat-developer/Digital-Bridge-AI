package db.ai.digitalbridgeai.service;

import db.ai.digitalbridgeai.dto.LessonDto;
import db.ai.digitalbridgeai.dto.UserDto;
import db.ai.digitalbridgeai.entity.Lesson;
import db.ai.digitalbridgeai.entity.Pazl;
import db.ai.digitalbridgeai.entity.User;
import db.ai.digitalbridgeai.repo.LessonRepo;
import db.ai.digitalbridgeai.repo.PazlRepo;
import db.ai.digitalbridgeai.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PazlRepo pazlRepo;
    @Autowired
    private LessonRepo lessonRepo;
    public List<UserDto> getUserList() {
        return userRepo.findAll().stream()
                .map(this::toDtoUser)
                .toList();
    }
    private UserDto toDtoUser(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail()
        );
    }

    public void createLesson(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonDto.lessonName());
        Pazl pazl = pazlRepo.findById(lessonDto.pazlId());
        lesson.setPazl(pazl);
        lessonRepo.save(lesson);
    }
}
