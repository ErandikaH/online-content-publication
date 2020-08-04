package sl.zerobeta.assessment.backend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class PublicationController {

    private final PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @ApiOperation(value = "Publication in Detail",
            response = Publication.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{publicationId}")
    public Publication getPublication(@PathVariable("publicationId") Long publicationId){
        return this.publicationService.viewContent(publicationId);
    }

    @ApiOperation(value = "Publication List",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("publications/{category}")
    public List<Publication> getPublicationList(@PathVariable("category") Integer category){
        return this.publicationService.findByCategory(category);
    }

    @ApiOperation(value = "Create Publication",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("publish/{userId}")
    public void addPublication(@PathVariable("userId") Long userId, @RequestBody PublicationDTO publicationDTO){
        this.publicationService.addContent(publicationDTO, userId);
    }

    @ApiOperation(value = "Update Publication",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("update/{publicationId}")
    public void updatePublication(@PathVariable("publicationId") Long publicationId,@RequestBody PublicationDTO publicationDTO){
        this.publicationService.updateContent(publicationDTO, publicationId);
    }

    @ApiOperation(value = "Delete Publication",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("delete")
    public void deletePublication(@RequestBody PublicationDeleteDTO publicationDeleteDTO){
        this.publicationService.deleteContent(publicationDeleteDTO);
    }
}
