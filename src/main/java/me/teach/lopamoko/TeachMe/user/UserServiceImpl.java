package me.teach.lopamoko.TeachMe.user;

import me.teach.lopamoko.TeachMe.security.SecurityService;
import me.teach.lopamoko.TeachMe.user_role.UserRole;
import me.teach.lopamoko.TeachMe.user_role.UserRoleDictionary;
import me.teach.lopamoko.TeachMe.user_role.UserRoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private SecurityService securityService;

    @Resource
    private UserModelToUserDataTransferObjectConverter userModelToUserDataTransferObjectConverter;

    @Resource
    private UserDataTransferObjectToUserModelConverter userDataTransferObjectToUserModelConverter;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDataTransferObject getUserById(Long userId) {
        UserModel userModel = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found, id " + userId));
        return userModelToUserDataTransferObjectConverter.convert(userModel);
    }

    @Override
    public UserDataTransferObject createNewUser(UserDataTransferObject userDataTransferObject) {
        UserModel userModel = userDataTransferObjectToUserModelConverter.convert(userDataTransferObject);
        UserRole userRole = userRoleService.createRole(UserRoleDictionary.USER);
        userModel.setUserPassword(bCryptPasswordEncoder.encode(userModel.getUserPassword()));
        userModel.getUserRoles().add(userRole);
        UserModel savedUser = userRepository.save(userModel);
        securityService.autoLogin(userDataTransferObject.getUserLogin(), userDataTransferObject.getUserPassword());
        return userModelToUserDataTransferObjectConverter.convert(savedUser);
    }

    @Override
    public UserDataTransferObject updateUser(UserDataTransferObject userDataTransferObject) {
        UserModel userModel = userDataTransferObjectToUserModelConverter.convert(userDataTransferObject);
        UserModel savedUser = userRepository.save(userModel);
        return userModelToUserDataTransferObjectConverter.convert(savedUser);
    }

    @Override
    public UserDataTransferObject getUserByLoginAndPassword(UserDataTransferObject userDataTransferObject) {
        UserModel userModel = userRepository.findDistinctFirstByUserLogin(userDataTransferObject.getUserLogin());
        boolean successPassword = bCryptPasswordEncoder.matches(userDataTransferObject.getUserPassword(), userModel.getUserPassword());
        if (successPassword) {
            securityService.autoLogin(userDataTransferObject.getUserLogin(), userDataTransferObject.getUserPassword());
            return userModelToUserDataTransferObjectConverter.convert(userModel);
        } else {
            throw new RuntimeException("Login or password incorrect");
        }
    }
}
