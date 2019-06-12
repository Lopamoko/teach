package me.teach.lopamoko.TeachMe.user;

import lombok.Data;

@Data
public class UserDataTransferObject {
    private Long userId;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
}
