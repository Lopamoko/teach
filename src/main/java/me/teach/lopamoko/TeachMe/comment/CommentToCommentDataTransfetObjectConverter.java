package me.teach.lopamoko.TeachMe.comment;

import me.teach.lopamoko.TeachMe.course.CourseToCourseDataTransferObjectConverter;
import me.teach.lopamoko.TeachMe.user.UserModelToUserDataTransferObjectConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class CommentToCommentDataTransfetObjectConverter {

    @Resource
    private CourseToCourseDataTransferObjectConverter courseToCourseDataTransferObjectConverter;

    @Resource
    private UserModelToUserDataTransferObjectConverter userModelToUserDataTransferObjectConverter;

    public CommentDataTransferObject convert(Comment comment) {
        CommentDataTransferObject commentDataTransferObject = new CommentDataTransferObject();
        commentDataTransferObject.setCommentDate(comment.getCommentDate());
        commentDataTransferObject.setCommentId(comment.getCommentId());
        commentDataTransferObject.setCommentText(comment.getCommentText());
        commentDataTransferObject.setUser(userModelToUserDataTransferObjectConverter.convert(comment.getUser()));
        return commentDataTransferObject;
    }
}
