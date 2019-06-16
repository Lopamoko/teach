package me.teach.lopamoko.TeachMe.course;

import lombok.extern.slf4j.Slf4j;
import me.teach.lopamoko.TeachMe.comment.CommentDataTransferObject;
import me.teach.lopamoko.TeachMe.comment.CommentToCommentDataTransfetObjectConverter;
import me.teach.lopamoko.TeachMe.course.theme.ThemeDataTransferObject;
import me.teach.lopamoko.TeachMe.course.theme.ThemeToThemeDataTransferObjectConverter;
import me.teach.lopamoko.TeachMe.user.UserModelToUserDataTransferObjectConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CourseToCourseDataTransferObjectConverter {

    @Resource
    private ThemeToThemeDataTransferObjectConverter themeToThemeDataTransferObjectConverter;

    @Resource
    private UserModelToUserDataTransferObjectConverter userModelToUserDataTransferObjectConverter;

    @Resource
    private CommentToCommentDataTransfetObjectConverter commentToCommentDataTransfetObjectConverter;

    public CourseDataTransferObject convert(Course course) {
        log.info("calling convert course data transfer object to course");
        CourseDataTransferObject courseDataTransferObject = new CourseDataTransferObject();
        courseDataTransferObject.setAuthor(userModelToUserDataTransferObjectConverter.convert(course.getAuthor()));
        courseDataTransferObject.setCourseDescription(course.getCourseDescription());
        courseDataTransferObject.setCourseId(course.getCourseId());
        courseDataTransferObject.setCourseImage(course.getCourseImage());
        courseDataTransferObject.setCourseName(course.getCourseName());
        courseDataTransferObject.setCoursePurpose(course.getCoursePurpose());
        courseDataTransferObject.setDateCreated(course.getDateCreated());
        courseDataTransferObject.setSubscriptionLevel(course.getSubscriptionLevel());
        Set<ThemeDataTransferObject> courseThemes = course.getThemes().stream()
                .map(theme -> themeToThemeDataTransferObjectConverter.convert(theme))
                .collect(Collectors.toSet());
        courseDataTransferObject.setThemes(courseThemes);
        Set<CommentDataTransferObject> comments = course.getComments().stream()
                .map(comment -> commentToCommentDataTransfetObjectConverter.convert(comment))
                .collect(Collectors.toSet());
        courseDataTransferObject.setComments(comments);
        return courseDataTransferObject;
    }

}
