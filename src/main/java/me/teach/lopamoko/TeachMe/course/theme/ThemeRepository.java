package me.teach.lopamoko.TeachMe.course.theme;

import me.teach.lopamoko.TeachMe.utils.PaginationAndSortDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends PaginationAndSortDslRepository<Theme, QTheme, Long> {
}
