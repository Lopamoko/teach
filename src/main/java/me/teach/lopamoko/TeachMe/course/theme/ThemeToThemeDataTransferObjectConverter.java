package me.teach.lopamoko.TeachMe.course.theme;

import lombok.extern.slf4j.Slf4j;
import me.teach.lopamoko.TeachMe.course.theme.lesson.LessonDataTransferObject;
import me.teach.lopamoko.TeachMe.course.theme.lesson.LessonToLessonDataTransferObjectConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ThemeToThemeDataTransferObjectConverter {

    @Resource
    private LessonToLessonDataTransferObjectConverter lessonToLessonDataTransferObjectConverter;

    public ThemeDataTransferObject convert(Theme theme) {
        log.info("starting convert theme - {} to themeDataTransferObject", theme);
        ThemeDataTransferObject themeDataTransferObject = new ThemeDataTransferObject();
        themeDataTransferObject.setThemeId(theme.getThemeId());
        themeDataTransferObject.setThemeImage(theme.getThemeImage());
        themeDataTransferObject.setThemeName(theme.getThemeName());
        Set<LessonDataTransferObject> lessons = theme.getLessons().stream()
                .map(lesson -> lessonToLessonDataTransferObjectConverter.convert(lesson))
                .collect(Collectors.toSet());
        themeDataTransferObject.setLessons(lessons);
        return themeDataTransferObject;

    }
}
