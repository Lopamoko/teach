package me.teach.lopamoko.TeachMe.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.course.Course;
import me.teach.lopamoko.TeachMe.subscription.Subscription;
import me.teach.lopamoko.TeachMe.subscription.UsersSubscriptions;
import me.teach.lopamoko.TeachMe.user_role.UserRole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "USER_SEQ", allocationSize = 1)
public class UserModel {
    @Id
    @GeneratedValue(generator = "USER_SEQ")
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;

    @Column(name = "USER_MIDDLE_NAME")
    private String userMiddleName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "USER_LOGIN")
    private String userLogin;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PHONE")
    private String userPhone;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ROLE_ID"))
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UsersSubscriptions> subscriptions = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Course> courses = new HashSet<>();

}
