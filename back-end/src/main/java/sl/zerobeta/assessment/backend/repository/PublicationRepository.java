package sl.zerobeta.assessment.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sl.zerobeta.assessment.backend.model.Publication;

import java.util.List;
import java.util.Optional;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>  {
    Optional<Publication> findByTitleAndCategoryAndStatusIn(String title, Integer category, List<Integer> status);
    Optional<Publication> findByTitleAndCategoryAndUserIdAndStatusIn(String title, Integer category, Long userId, List<Integer> status);
    Optional<Publication> findByIdAndStatusIn(Long id, List<Integer> status);
    List<Publication> findByCategoryAndStatusIn(Integer category, List<Integer> status);
}
