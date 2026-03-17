package Model;

import java.time.LocalDate;

public class Post {
    private int postId;
    private String username;
    private Community community;
    private String content;
    private LocalDate createdAt;

    public Post(int postId, String username, Community community, String content) {
        this.postId = postId;
        this.username = username;
        this.community = community;
        this.content = content;
        this.createdAt = LocalDate.now();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "{" +
                "Posted By = '" + username + '\'' +
                ", Content = '" + content + '\'' +
                ", Created At = " + createdAt +
                '}';
    }
}
