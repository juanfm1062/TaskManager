package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.Model.Comment;
import TaskMangement.com.Task.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByTaskId(Long taskId) {
        return commentRepository.findByTask_Id(taskId);
    }

    //Additional methods as needed
}
