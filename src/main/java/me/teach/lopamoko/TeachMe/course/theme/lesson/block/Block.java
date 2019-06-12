package me.teach.lopamoko.TeachMe.course.theme.lesson.block;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.course.theme.lesson.Lesson;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "BLOCK")
@SequenceGenerator(name = "BLOCK_SEQ", allocationSize = 1)
public class Block {
    @Id
    @Column(name = "BLOCK_ID")
    @GeneratedValue(generator = "BLOCK_SEQ")
    private Long blockId;

    @Column(name = "BLOCK_POSITION")
    private Integer blockPosition;

    @ManyToOne
    @JoinColumn(name = "LESSON_ID")
    private Lesson lesson;

    @Column(name = "BLOCK_TYPE")
    private String blockType;

    @Column(name = "BLOCK_DATA")
    private String blockData;

}
