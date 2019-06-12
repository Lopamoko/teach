package me.teach.lopamoko.TeachMe.course.theme.lesson;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.course.theme.Theme;
import me.teach.lopamoko.TeachMe.course.theme.lesson.block.Block;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "LESSON_SEQ", allocationSize = 1)
@Table(name = "LESSON")
public class Lesson {

    @Id
    @GeneratedValue(generator = "LESSON_SEQ")
    @Column(name = "LESSON_ID")
    private Long lessonId;

    @ManyToOne
    @JoinColumn(name = "THEME_ID")
    private Theme theme;

    @Column(name = "LESSON_NUMBER")
    private Integer lessonNumber;

    @Column(name = "LESSON_NAME")
    private String lessonName;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.PERSIST)
    private Set<Block> blocks = new HashSet<>();

    @Column(name = "LESSON_IMAGE")
    private String lessonImage;
}
