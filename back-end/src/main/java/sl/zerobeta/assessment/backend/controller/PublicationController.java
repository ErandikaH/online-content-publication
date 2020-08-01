package sl.zerobeta.assessment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sl.zerobeta.assessment.backend.dto.PublicationDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDeleteDTO;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.service.PublicationService;

import java.util.List;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@RestController
@RequestMapping("content")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationController {

    private final PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("{publicationId}")
    public Publication getPublication(@PathVariable("publicationId") Long publicationId){
        return this.publicationService.viewContent(publicationId);
    }

    @GetMapping("publications/{category}")
    public List<Publication> getPublicationList(@PathVariable("category") Integer category){
        return this.publicationService.findByCategory(category);
    }

    @PostMapping("{userId}")
    public void addPublication(@PathVariable("userId") Long userId, @RequestBody PublicationDTO publicationDTO){
        this.publicationService.addContent(publicationDTO, userId);
    }

    @PutMapping("{publicationId}")
    public void updatePublication(@PathVariable("publicationId") Long publicationId,@RequestBody PublicationDTO publicationDTO){
        this.publicationService.updateContent(publicationDTO, publicationId);
    }

    @PutMapping("delete")
    public void deletePublication(@RequestBody PublicationDeleteDTO publicationDeleteDTO){
        this.publicationService.deleteContent(publicationDeleteDTO);
    }
}
