package me.teach.lopamoko.TeachMe.user;

import org.springframework.stereotype.Component;

@Component
public class UserDataTransferObjectToUserModelConverter {


    public UserModel convert(UserDataTransferObject userDataTransferObject) {
        UserModel userModel = new UserModel();
        userModel.setUserFirstName(userDataTransferObject.getUserFirstName());
        userModel.setUserId(userDataTransferObject.getUserId());
        userModel.setUserLastName(userDataTransferObject.getUserLastName());
        userModel.setUserMiddleName(userDataTransferObject.getUserMiddleName());
        userModel.setUserLogin(userDataTransferObject.getUserLogin());
        userModel.setUserPassword(userDataTransferObject.getUserPassword());
        return userModel;
    }
}
