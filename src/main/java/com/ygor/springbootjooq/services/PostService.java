package com.ygor.springbootjooq.services;

import com.ygor.springbootjooq.model.Comment;
import com.ygor.springbootjooq.model.Post;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.ygor.springbootjooq.domain.tables.Posts.POSTS;
import static com.ygor.springbootjooq.domain.tables.Comments.COMMENTS;
import com.ygor.springbootjooq.domain.tables.records.PostsRecord;
import com.ygor.springbootjooq.domain.tables.records.CommentsRecord;

@Service
@Transactional
public class PostService {

    private final DSLContext dsl;

    @Autowired
    public PostService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Post createPost(Post post) {
        PostsRecord postsRecord = dsl.insertInto(POSTS)
                .set(POSTS.TITLE, post.getTitle())
                .set(POSTS.CONTENT, post.getContent())
                .set(POSTS.CREATED_ON, post.getCreatedOn())
                .returning(POSTS.ID)
                .fetchOne();

        post.setId(postsRecord.getId());

        return post;
    }

    public Comment createComment(Comment comment) {
        CommentsRecord commentsRecord = dsl.insertInto(COMMENTS)
                .set(COMMENTS.POST_ID, comment.getPostId())
                .set(COMMENTS.NAME, comment.getName())
                .set(COMMENTS.EMAIL, comment.getEmail())
                .set(COMMENTS.CONTENT, comment.getContent())
                .set(COMMENTS.CREATED_ON, comment.getCreatedOn())
                .returning(COMMENTS.ID)
                .fetchOne();

        comment.setId(commentsRecord.getId());

        return comment;
    }

    public int updatePost(Post post) {
        return dsl.update(POSTS)
                .set(POSTS.TITLE, post.getTitle())
                .set(POSTS.CONTENT, post.getContent())
                .set(POSTS.CREATED_ON, post.getCreatedOn())
                .where(POSTS.ID.eq(post.getId()))
                .execute();
    }

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        Result<Record> result = dsl.select().from(POSTS).fetch();

        for (Record r : result) {
            posts.add(getPostEntity(r));
        }

        return posts;
    }

    public Post getPostById(int id) {
        Record postRecord = dsl.select().from(POSTS).where(POSTS.ID.eq(id)).fetchOne();

        if (postRecord != null) {

            Post post = getPostEntity(postRecord);

            Result<Record> commentRecord = dsl.select().from(COMMENTS).where(COMMENTS.POST_ID.eq(post.getId())).fetch();

            List<Comment> comments = new ArrayList<>();

            for (Record r : commentRecord) {
                comments.add(getCommentEntity(r));
            }
            post.setComments(comments);

            return post;
        }

        return null;
    }

    public Comment getCommentById(int id) {
        Record commentRecord = dsl.select().from(COMMENTS).where(COMMENTS.ID.eq(id)).fetchOne();

        if (commentRecord != null) {
            return getCommentEntity(commentRecord);

        }
        return null;
    }

    public void deleteComment(int id) {
        dsl.deleteFrom(COMMENTS).where(COMMENTS.ID.eq(id)).execute();
    }

    private Post getPostEntity(Record r) {
        Post post = new Post();

        post.setId(r.getValue(POSTS.ID, Integer.class));
        post.setTitle(r.getValue(POSTS.TITLE, String.class));
        post.setContent(r.getValue(POSTS.CONTENT, String.class));
        post.setCreatedOn(r.getValue(POSTS.CREATED_ON, Timestamp.class));

        return post;
    }

    private Comment getCommentEntity(Record r) {
        Comment comment = new Comment();

        comment.setId(r.getValue(COMMENTS.ID, Integer.class));
        comment.setPostId(r.getValue(COMMENTS.POST_ID, Integer.class));
        comment.setName(r.getValue(COMMENTS.NAME, String.class));
        comment.setEmail(r.getValue(COMMENTS.EMAIL, String.class));
        comment.setContent(r.getValue(COMMENTS.CONTENT, String.class));
        comment.setCreatedOn(r.getValue(COMMENTS.CREATED_ON, Timestamp.class));

        return comment;
    }
}
