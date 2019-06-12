package me.teach.lopamoko.TeachMe.course;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    Optional<Course> findDistinctByCourseId(Long courseID);
}
