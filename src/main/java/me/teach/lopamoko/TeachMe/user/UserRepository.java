package me.teach.lopamoko.TeachMe.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
    UserModel findDistinctFirstByUserLogin(String userLogin);
}
