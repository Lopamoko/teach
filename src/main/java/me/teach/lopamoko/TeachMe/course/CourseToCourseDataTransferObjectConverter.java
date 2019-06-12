package me.teach.lopamoko.TeachMe.course;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseToCourseDataTransferObjectConverter {

    public CourseDataTransferObject convert(Course course) {
        log.info("calling convert course data transfer object to course");
        return new CourseDataTransferObject();
    }

}
