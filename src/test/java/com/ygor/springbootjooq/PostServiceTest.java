package com.ygor.springbootjooq;

import com.ygor.springbootjooq.model.Comment;
import com.ygor.springbootjooq.model.Post;
import com.ygor.springbootjooq.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void findAllPosts() {
        List<Post> posts = postService.getAllPosts();

        assertNotNull(posts);
        assertFalse(posts.isEmpty());

        for (Post post : posts) {
            printPost(post);
            System.out.println("-----------------------------");
        }
    }

    @Test
    public void findPostById() {
        int id = 1;

        Post post = postService.getPostById(id);

        assertNotNull(post);

        printPost(post);

        for (Comment comment : post.getComments()) {
            System.out.println("-------------------------------");
            printComment(comment);
        }
    }

    @Test
    public void findCommentById() {
        int id = 1;

        Comment comment = postService.getCommentById(id);

        assertNotNull(comment);

        printComment(comment);
    }

    @Test
    public void createPost() {
        Post post = new Post("My new Post", "This is my new test post", new Timestamp(System.currentTimeMillis()));

        Post savedPost = postService.createPost(post);
        Post newPost = postService.getPostById(savedPost.getId());

        assertNotNull(newPost);
        assertEquals("My new Post", newPost.getTitle());
        assertEquals("This is my new test post", newPost.getContent());

        printPost(newPost);
    }

    @Test
    public void createComment() {
        int post_id = 1;

        Comment comment = new Comment(post_id, "Ygor", "ygor@gmail.com",
                "This is my new comment on post1", new Timestamp(System.currentTimeMillis()));

        Comment savedComment = postService.createComment(comment);
        Post post = postService.getPostById(post_id);

        assertNotNull(post.getComments());

        for (Comment comm : post.getComments()) {

            if (savedComment.getId() == comm.getId()) {
                assertEquals("Ygor", comm.getName());
                assertEquals("ygor@gmail.com", comm.getEmail());
                assertEquals("This is my new comment on post1", comm.getContent());

                printComment(comm);
            }
        }
    }

    @Test
    public void updatePost() {
        int id = 1;

        Post post = postService.getPostById(id);

        post.setTitle("Title edited");
        post.setContent("Content edited");
        post.setCreatedOn(new Timestamp(System.currentTimeMillis()));

        postService.updatePost(post);

        Post newPost = postService.getPostById(id);

        assertNotNull(newPost);
        assertEquals("Title edited", newPost.getTitle());
        assertEquals("Content edited", newPost.getContent());

        printPost(newPost);
    }

    @Test
    public void deleteComment() {
        int id = 1;

        postService.deleteComment(id);

        Comment comment = postService.getCommentById(id);

        assertNull(comment);
    }

    private void printPost(Post post) {
        System.out.println("ID: " + post.getId());
        System.out.println("TITLE: " + post.getTitle());
        System.out.println("CONTENT: " + post.getContent());
        System.out.println("CREATED ON: " + post.getCreatedOn());
    }

    private void printComment(Comment comment) {
        System.out.println("ID: " + comment.getId());
        System.out.println("NAME: " + comment.getName());
        System.out.println("EMAIL: " + comment.getEmail());
        System.out.println("CONTENT: " + comment.getContent());
        System.out.println("CREATED ON: " + comment.getCreatedOn());

    }
}
