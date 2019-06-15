package me.teach.lopamoko.TeachMe.course;

import lombok.extern.slf4j.Slf4j;
import me.teach.lopamoko.TeachMe.utils.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/course")
@Slf4j
public class CourseController {
    @Resource
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseDataTransferObject>> getCourses(PageRequest qPageRequest) {
        log.trace("calling get all courses");
        return ResponseEntity.ok(courseService.getAllCourse(qPageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDataTransferObject> getCourseById(@PathVariable Long id) {
        log.trace("calling get course by id - {}", id);
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDataTransferObject> createCourse(@RequestBody CourseDataTransferObject courseDataTransferObject) {
        log.trace("calling create course");
        return ResponseEntity.ok(courseService.createCourse(courseDataTransferObject));
    }

    @PutMapping
    public ResponseEntity<CourseDataTransferObject> updateCourse(@RequestBody CourseDataTransferObject courseDataTransferObject) {
        log.trace("calling update course");
        return ResponseEntity.ok(courseService.updateCourse(courseDataTransferObject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCourse(@PathVariable Long id) {
        log.trace("calling remove course");
        courseService.removeCourse(id);
        return ResponseEntity.ok("Success removed course with id " + id);
    }
}
