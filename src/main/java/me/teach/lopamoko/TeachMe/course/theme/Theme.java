package me.teach.lopamoko.TeachMe.course.theme;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.course.Course;
import me.teach.lopamoko.TeachMe.course.theme.lesson.Lesson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@SequenceGenerator(name = "THEME_SEQ", allocationSize = 1)
@Table(name = "THEME")
public class Theme {

    @Id
    @GeneratedValue(generator = "THEME_SEQ")
    @Column(name = "THEME_ID")
    private Long themeId;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @Column(name = "THEME_NAME")
    private String themeName;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.PERSIST)
    private Set<Lesson> lessons = new HashSet<>();

    @Column(name = "THEME_IMAGE")
    private String themeImage;

}
