package sl.zerobeta.assessment.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.zerobeta.assessment.backend.dto.PublicationCommentDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDTO;
import sl.zerobeta.assessment.backend.dto.PublicationDeleteDTO;
import sl.zerobeta.assessment.backend.exceptions.CategoryNotFoundException;
import sl.zerobeta.assessment.backend.exceptions.PublicationAlreadyExistException;
import sl.zerobeta.assessment.backend.exceptions.PublicationNotFoundException;
import sl.zerobeta.assessment.backend.exceptions.UserNotFoundException;
import sl.zerobeta.assessment.backend.model.Comment;
import sl.zerobeta.assessment.backend.model.NotificationMessage;
import sl.zerobeta.assessment.backend.model.Publication;
import sl.zerobeta.assessment.backend.model.User;
import sl.zerobeta.assessment.backend.model.enums.Category;
import sl.zerobeta.assessment.backend.model.enums.ContentStatus;
import sl.zerobeta.assessment.backend.model.enums.NotificationStatus;
import sl.zerobeta.assessment.backend.repository.CommentRepository;
import sl.zerobeta.assessment.backend.repository.NotificationRepository;
import sl.zerobeta.assessment.backend.repository.PublicationRepository;
import sl.zerobeta.assessment.backend.repository.UserRepository;
import sl.zerobeta.assessment.backend.service.NotificationService;
import sl.zerobeta.assessment.backend.service.PublicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Erandika Harshani
 * Created on July 31, 2020
 */
@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final ModelMapper modelMapper;

    @Autowired
    public PublicationServiceImpl(PublicationRepository publicationRepository,
                                  CommentRepository commentRepository,
                                  UserRepository userRepository,
                                  NotificationService notificationService,
                                  ModelMapper modelMapper) {
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addContent(PublicationDTO publicationDTO, Long userId) {
        Publication publication = this.modelMapper.map(publicationDTO, Publication.class);
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            publication.setUser(optionalUser.get());
        }else{
            throw new UserNotFoundException("User not found");
        }
        List<Integer> statusList = new ArrayList<>();
        statusList.add(ContentStatus.CREATED.getContentStatus());
        statusList.add(ContentStatus.UPDATED.getContentStatus());
        if(Category.ML_AI.getCategoryNumber()==publicationDTO.getCategory() || Category.BIG_DATA.getCategoryNumber()==publicationDTO.getCategory() || Category.MICROSERVICES.getCategoryNumber()==publicationDTO.getCategory()){
            Optional<Publication> optionalPublication = this.publicationRepository.findByTitleAndCategoryAndUserIdAndStatusIn(publicationDTO.getTitle(), publicationDTO.getCategory(), userId, statusList);
            if(optionalPublication.isPresent()){
                throw new PublicationAlreadyExistException("There is a publication with given title and category. Please provide different title");
            }
        }else{
            throw new CategoryNotFoundException("Given Category is not found: "+ publicationDTO.getCategory());
        }

        publication.setStatus(ContentStatus.CREATED.getContentStatus());
        this.publicationRepository.save(publication);
        this.notificationService.addNotificationMessage(userId, publication);
    }

    @Override
    public void updateContent(PublicationDTO publicationDTO, Long publicationId) {
        List<Integer> statusList = new ArrayList<>();
        statusList.add(ContentStatus.CREATED.getContentStatus());
        statusList.add(ContentStatus.UPDATED.getContentStatus());
        Publication publication = null;
        Optional<Publication> optionalPublication = this.publicationRepository.findByIdAndStatusIn(publicationId, statusList);
        if(!optionalPublication.isPresent()){
            throw new PublicationNotFoundException("There is no publication with given title and category. Please provide different title");
        }
        publication = optionalPublication.get();
        if(null!=publicationDTO.getTitle() && !publicationDTO.getTitle().isEmpty()){
            publication.setTitle(publicationDTO.getTitle());
        }
        if(null!=publicationDTO.getSummary() && !publicationDTO.getSummary().isEmpty()){
            publication.setSummary(publicationDTO.getSummary());
        }
        if(null!=publicationDTO.getDetails() && !publicationDTO.getDetails().isEmpty()){
            publication.setDetails(publicationDTO.getDetails());
        }
        if(null!=publicationDTO.getCategory()){
            if(Category.ML_AI.getCategoryNumber()==publicationDTO.getCategory() || Category.BIG_DATA.getCategoryNumber()==publicationDTO.getCategory() || Category.MICROSERVICES.getCategoryNumber()==publicationDTO.getCategory()){
                publication.setCategory(publicationDTO.getCategory());
            }
        }
        publication.setStatus(ContentStatus.UPDATED.getContentStatus());
        this.publicationRepository.save(publication);
        this.notificationService.addNotificationMessage(publication.getUser().getId(), publication);
    }

    @Override
    public void deleteContent(PublicationDeleteDTO publicationDeleteDTO) {
        Optional<Publication> optionalPublication = this.publicationRepository.findById(publicationDeleteDTO.getPublicationId());
        if(!optionalPublication.isPresent()){
            throw new PublicationNotFoundException("There is no publication with given title and category. Please provide different title");
        }
        Publication publication = optionalPublication.get();
        publication.setStatus(ContentStatus.DELETED.getContentStatus());
        this.publicationRepository.save(publication);
        this.notificationService.addNotificationMessage(publication.getUser().getId(), publication);
    }

    @Override
    public List<Publication> findByCategory(Integer category) {
        List<Integer> statusList = new ArrayList<>();
        statusList.add(ContentStatus.CREATED.getContentStatus());
        statusList.add(ContentStatus.UPDATED.getContentStatus());
        List<Publication> publicationList = null;
        publicationList = this.publicationRepository.findByCategoryAndStatusIn(category, statusList);
        if(!publicationList.isEmpty()){
            return publicationList;
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public Publication viewContent(Long publicationId) {
        List<Integer> statusList = new ArrayList<>();
        statusList.add(ContentStatus.CREATED.getContentStatus());
        statusList.add(ContentStatus.UPDATED.getContentStatus());
        Optional<Publication> optionalPublication = this.publicationRepository.findByIdAndStatusIn(publicationId, statusList);
        Publication publication = null;
        if(optionalPublication.isPresent()){
            publication = optionalPublication.get();
        }else{
            throw new PublicationNotFoundException("Not found");
        }
        List<Comment> commentList = commentRepository.findByPublicationId(publicationId);
        if(!commentList.isEmpty()){
            publication.setCommentList(commentList);
        }
        return publication;
    }
}
