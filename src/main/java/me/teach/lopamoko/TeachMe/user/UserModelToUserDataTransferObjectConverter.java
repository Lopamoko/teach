package me.teach.lopamoko.TeachMe.user;

import org.springframework.stereotype.Component;

@Component
public class UserModelToUserDataTransferObjectConverter {

    public UserDataTransferObject convert(UserModel userModel) {
        UserDataTransferObject userDataTransferObject = new UserDataTransferObject();
        userDataTransferObject.setUserFirstName(userModel.getUserFirstName());
        userDataTransferObject.setUserId(userModel.getUserId());
        userDataTransferObject.setUserLastName(userModel.getUserLastName());
        userDataTransferObject.setUserMiddleName(userModel.getUserMiddleName());
        userDataTransferObject.setUserLogin(userModel.getUserLogin());
        userDataTransferObject.setUserPassword(userModel.getUserPassword());
        return userDataTransferObject;
    }
}
