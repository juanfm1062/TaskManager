package TaskMangement.com.Task.Security;

import TaskMangement.com.Task.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("commentSecurityService")
public class CommentSecurityService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentSecurityService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public boolean isOwnerOrAdmin(Long commentId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        return commentRepository.findById(commentId)
                .map(comment -> comment.getUser().getUsername().equals(currentUsername) ||
                        authentication.getAuthorities().stream()
                                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN")))
                .orElse(false);
    }
}
