package me.teach.lopamoko.TeachMe.course.theme.lesson;

import lombok.extern.slf4j.Slf4j;
import me.teach.lopamoko.TeachMe.course.theme.lesson.block.BlockDataTransferObject;
import me.teach.lopamoko.TeachMe.course.theme.lesson.block.BlockToBlockDataTransferObjectConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class LessonToLessonDataTransferObjectConverter {

    @Resource
    private BlockToBlockDataTransferObjectConverter blockToBlockDataTransferObjectConverter;

    public LessonDataTransferObject convert(Lesson lesson) {
        LessonDataTransferObject lessonDataTransferObject = new LessonDataTransferObject();
        lessonDataTransferObject.setLessonId(lesson.getLessonId());
        lessonDataTransferObject.setLessonImage(lesson.getLessonImage());
        lessonDataTransferObject.setLessonName(lesson.getLessonName());
        lessonDataTransferObject.setLessonNumber(lesson.getLessonNumber());
        lessonDataTransferObject.setLessonType(lesson.getLessonType());
        Set<BlockDataTransferObject> blocks = lesson.getBlocks().stream()
                .map(block -> blockToBlockDataTransferObjectConverter.convert(block))
                .collect(Collectors.toSet());
        lessonDataTransferObject.setBlocks(blocks);
        return lessonDataTransferObject;
    }
}
