package me.teach.lopamoko.TeachMe.course.theme.lesson.block;

import me.teach.lopamoko.TeachMe.utils.PaginationAndSortDslRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends PaginationAndSortDslRepository<Block, QBlock, Long> {
}
