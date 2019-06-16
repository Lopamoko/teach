package me.teach.lopamoko.TeachMe.course.theme.lesson;

import me.teach.lopamoko.TeachMe.utils.PaginationAndSortDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends PaginationAndSortDslRepository<Lesson, QLesson, Long> {
}
