package me.teach.lopamoko.TeachMe.comment;

import lombok.Data;
import me.teach.lopamoko.TeachMe.course.CourseDataTransferObject;
import me.teach.lopamoko.TeachMe.user.UserDataTransferObject;

import java.util.Date;

@Data
public class CommentDataTransferObject {
    private Long commentId;
    private Date commentDate;
    private String commentText;
    private UserDataTransferObject user;
}
