package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.CommentDTO;
import TaskMangement.com.Task.Model.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(CommentDTO commentDTO);
    List<Comment> findAllCommentsForTask(Long taskId);
    Comment updateComment(Long commentId, CommentDTO commentDTO);
    void deleteComment(Long commentId);
}
