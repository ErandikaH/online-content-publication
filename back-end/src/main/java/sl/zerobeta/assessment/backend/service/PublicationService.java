package sl.zerobeta.assessment.backend.service;

import sl.zerobeta.assessment.backend.dto.PublicationDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDeleteDTO;
import sl.zerobeta.assessment.backend.model.Publication;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
public interface PublicationService {

    void addContent(PublicationDTO publicationDTO, Long userId);

    void updateContent(PublicationDTO publicationDTO, Long publicationId);

    void deleteContent(PublicationDeleteDTO publicationDeleteDTO);

    List<Publication> findByCategory(Integer category);

    Publication viewContent(Long publicationId);
}
