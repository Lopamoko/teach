package me.teach.lopamoko.TeachMe.comment;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.user.UserModel;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "COMMENT_SEQ", allocationSize = 1)
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(generator = "COMMENT_SEQ")
    @Column(name = "COMMENT_ID")
    private Long commentId;

    @Column(name = "COMMENT_DATE")
    private Date commentDate;

    @Column(name = "COMMENT_TEXT")
    private String commentText;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserModel user;
}
