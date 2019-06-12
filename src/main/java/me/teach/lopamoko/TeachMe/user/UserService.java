package me.teach.lopamoko.TeachMe.user;

public interface UserService {
    void removeUser(Long userId);
    UserDataTransferObject getUserById(Long userId);
    UserDataTransferObject createNewUser(UserDataTransferObject userDataTransferObject);
    UserDataTransferObject updateUser(UserDataTransferObject userDataTransferObject);
    UserDataTransferObject getUserByLoginAndPassword(UserDataTransferObject userDataTransferObject);
}
