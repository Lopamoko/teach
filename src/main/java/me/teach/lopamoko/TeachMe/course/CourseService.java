package me.teach.lopamoko.TeachMe.course;

import me.teach.lopamoko.TeachMe.utils.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

public interface CourseService {
    CourseDataTransferObject createCourse(CourseDataTransferObject courseDataTransferObject);
    CourseDataTransferObject updateCourse(CourseDataTransferObject courseDataTransferObject);
    CourseDataTransferObject getCourseById(Long courseId);
    Page<CourseDataTransferObject> getAllCourse(PageRequest pageRequest);
    void removeCourse(Long courseId);
}
