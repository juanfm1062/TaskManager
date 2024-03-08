package TaskMangement.com.Task.Controller;

import TaskMangement.com.Task.Model.Comment;
import TaskMangement.com.Task.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskmanager/tasks/{taskId}/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> addCommentToTask(@PathVariable Long taskId, @RequestBody Comment comment) {
        //Assuming comment's task is set in the service or here before saving
        Comment addedComment = commentService.addComment(comment);
        return ResponseEntity.ok(addedComment);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getCommentsByTaskId(@PathVariable Long taskId) {
        List<Comment> comments = commentService.getCommentsByTaskId(taskId);
        if (comments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comments);
    }

    //Additional endpoints as needed
}
