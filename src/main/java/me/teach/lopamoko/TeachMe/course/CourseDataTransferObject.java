package me.teach.lopamoko.TeachMe.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import me.teach.lopamoko.TeachMe.comment.CommentDataTransferObject;
import me.teach.lopamoko.TeachMe.course.theme.ThemeDataTransferObject;
import me.teach.lopamoko.TeachMe.user.UserDataTransferObject;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDataTransferObject {
    private Long courseId;
    private UserDataTransferObject author;
    private Set<ThemeDataTransferObject> themes = new HashSet<>();
    private String courseName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Timestamp dateCreated;
    private String courseDescription;
    private String coursePurpose;
    private String courseImage;
    private Integer subscriptionLevel;
    private Set<CommentDataTransferObject> comments;
}
