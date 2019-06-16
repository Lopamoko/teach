package me.teach.lopamoko.TeachMe.course.theme.lesson.block;

import lombok.Data;
import me.teach.lopamoko.TeachMe.course.theme.lesson.Lesson;

@Data
public class BlockDataTransferObject {
    private Long blockId;
    private Integer blockPosition;
    private Lesson lesson;
    private String blockType;
    private String blockData;

}
