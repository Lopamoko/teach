package me.teach.lopamoko.TeachMe.course;

import me.teach.lopamoko.TeachMe.utils.PaginationAndSortDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends PaginationAndSortDslRepository<Course, QCourse, Long> {

}
