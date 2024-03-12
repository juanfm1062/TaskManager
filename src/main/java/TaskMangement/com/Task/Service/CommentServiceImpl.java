package TaskMangement.com.Task.Service;

import TaskMangement.com.Task.DTO.CommentDTO;
import TaskMangement.com.Task.Model.Comment;
import TaskMangement.com.Task.Model.Task;
import TaskMangement.com.Task.Repository.CommentRepository;
import TaskMangement.com.Task.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Comment addComment(CommentDTO commentDTO) {
        Task task = taskRepository.findById(commentDTO.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        Comment comment = new Comment();
        comment.setTask(task);
        comment.setContent(commentDTO.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllCommentsForTask(Long taskId) {
        return commentRepository.findByTask_Id(taskId);
    }

    @Override
    public Comment updateComment(Long commentId, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setContent(commentDTO.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
