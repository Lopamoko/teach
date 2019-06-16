package me.teach.lopamoko.TeachMe.course;

import lombok.extern.slf4j.Slf4j;
import me.teach.lopamoko.TeachMe.utils.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseRepository courseRepository;

    @Resource
    private CourseDataTransferObjectToCourseConverter courseDataTransferObjectToCourseConverter;

    @Resource
    private CourseToCourseDataTransferObjectConverter courseToCourseDataTransferObjectConverter;


    @Override
    public CourseDataTransferObject createCourse(CourseDataTransferObject courseDataTransferObject) {
        Course course = courseDataTransferObjectToCourseConverter.convert(courseDataTransferObject);
        Course savedCourse = courseRepository.save(course);
        return courseToCourseDataTransferObjectConverter.convert(savedCourse);
    }

    @Override
    public CourseDataTransferObject updateCourse(CourseDataTransferObject courseDataTransferObject) {
        Course course = courseDataTransferObjectToCourseConverter.convert(courseDataTransferObject);
        Course savedCourse = courseRepository.save(course);
        return courseToCourseDataTransferObjectConverter.convert(savedCourse);
    }

    @Override
    public CourseDataTransferObject getCourseById(Long courseId) {
        Course course = courseRepository.findOne(QCourse.course.courseId.eq(courseId))
                .orElseThrow(() -> new RuntimeException("Course with not found with id " + courseId));
        return courseToCourseDataTransferObjectConverter.convert(course);
    }

    @Override
    public Page<CourseDataTransferObject> getAllCourse(PageRequest pageRequest) {
        QPageRequest qPageRequest = new QPageRequest(pageRequest.getPage(), pageRequest.getSize());
        List<CourseDataTransferObject> courseDataTransferObjectPage = courseRepository.findAll(qPageRequest).stream()
                .map(course -> courseToCourseDataTransferObjectConverter.convert(course))
                .collect(Collectors.toList());
        return new PageImpl<>(courseDataTransferObjectPage);
    }

    @Override
    public void removeCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
