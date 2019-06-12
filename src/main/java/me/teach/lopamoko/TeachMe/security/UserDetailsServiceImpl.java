package me.teach.lopamoko.TeachMe.security;

import me.teach.lopamoko.TeachMe.user.UserModel;
import me.teach.lopamoko.TeachMe.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findDistinctFirstByUserLogin(userLogin);
        Set<GrantedAuthority> grantedAuthoritySet = userModel.getUserRoles().stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getUserRoleName()))
                .collect(Collectors.toSet());
        return new User(userModel.getUserLogin(), userModel.getUserPassword(), grantedAuthoritySet);
    }
}
