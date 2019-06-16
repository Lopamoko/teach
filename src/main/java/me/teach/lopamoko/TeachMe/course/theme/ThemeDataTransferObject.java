package me.teach.lopamoko.TeachMe.course.theme;

import lombok.Data;
import me.teach.lopamoko.TeachMe.course.CourseDataTransferObject;
import me.teach.lopamoko.TeachMe.course.theme.lesson.LessonDataTransferObject;

import java.util.HashSet;
import java.util.Set;

@Data
public class ThemeDataTransferObject {
    private Long themeId;
    private CourseDataTransferObject course;
    private String themeName;
    private Set<LessonDataTransferObject> lessons = new HashSet<>();
    private String themeImage;
}

