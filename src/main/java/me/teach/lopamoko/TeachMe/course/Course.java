package me.teach.lopamoko.TeachMe.course;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.course.theme.Theme;
import me.teach.lopamoko.TeachMe.subscription.Subscription;
import me.teach.lopamoko.TeachMe.user.UserModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Table(name = "COURSE")
@Entity
@Getter
@Setter
@SequenceGenerator(name = "COURSE_SEQ", allocationSize = 1)
public class Course {

    @Id
    @GeneratedValue(generator = "COURSE_SEQ")
    @Column(name = "COURSE_ID")
    private Long courseId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserModel author;

    @OneToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private Set<Theme> themes = new HashSet<>();

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "DATE_CREATED")
    private Timestamp dateCreated;

    @Column(name = "COURSE_DESCRIPTION")
    private String courseDescription;

    @Column(name = "COURSE_PURPOSE")
    private String coursePurpose;

    @Column(name = "COURSE_IMAGE")
    private String courseImage;

    @Column(name = "SUBSCRIPTION_LEVEL")
    private Integer subscriptionLevel;
}
