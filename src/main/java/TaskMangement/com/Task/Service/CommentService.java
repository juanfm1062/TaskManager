package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.CommentDTO;
import TaskMangement.com.Task.Model.Comment;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface CommentService {
    Comment addComment(CommentDTO commentDTO);
    List<Comment> findAllCommentsForTask(Long taskId);
    @PreAuthorize("hasRole('ROLE_ADMIN') or @commentSecurityService.isOwnerOrAdmin(#commentId, authentication.name)")
    Comment updateComment(Long commentId, CommentDTO commentDTO);
    @PreAuthorize("hasRole('ROLE_ADMIN') or @commentSecurityService.isOwnerOrAdmin(#commentId)")
    void deleteComment(Long commentId);
}
