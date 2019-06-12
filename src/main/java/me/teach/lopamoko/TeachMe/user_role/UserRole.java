package me.teach.lopamoko.TeachMe.user_role;

import lombok.*;
import me.teach.lopamoko.TeachMe.user.UserModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_ROLE")
@SequenceGenerator(name = "USER_ROLE_SEQ", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(generator = "USER_ROLE_SEQ")
    @Column(name = "USER_ROLE_ID")
    private Long userRoleId;

    @Column(name = "USER_ROLE_NAME")
    private String userRoleName;

    @ManyToMany(mappedBy = "userRoles")
    private Set<UserModel> users = new HashSet<>();



}
