package me.teach.lopamoko.TeachMe.course.theme.lesson;

import lombok.Data;
import me.teach.lopamoko.TeachMe.course.theme.Theme;
import me.teach.lopamoko.TeachMe.course.theme.lesson.block.BlockDataTransferObject;

import java.util.HashSet;
import java.util.Set;

@Data
public class LessonDataTransferObject {
    private Long lessonId;
    private Theme theme;
    private Integer lessonNumber;
    private String lessonName;
    private Set<BlockDataTransferObject> blocks = new HashSet<>();
    private String lessonImage;
    private String lessonType;
}
