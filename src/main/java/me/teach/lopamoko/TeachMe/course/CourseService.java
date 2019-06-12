package me.teach.lopamoko.TeachMe.course;

import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

public interface CourseService {
    CourseDataTransferObject createCourse(CourseDataTransferObject courseDataTransferObject);
    CourseDataTransferObject updateCourse(CourseDataTransferObject courseDataTransferObject);
    CourseDataTransferObject getCourseById(Long courseId);
    Page<CourseDataTransferObject> getAllCourse(QPageRequest qPageRequest);
    void removeCourse(Long courseId);
}
