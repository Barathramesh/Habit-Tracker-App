package Model;

import java.time.LocalDate;

public class Post {
    private int postId;
    private String username;
    private Community community;
    private String content;
    private LocalDate createdAt;
    private Reward reward;

    public Post(int postId, String username, Community community, String content) {
        this.postId = postId;
        this.username = username;
        this.community = community;
        this.content = content;
        this.createdAt = LocalDate.now();
    }

    public Post(int postId, String username, Community community, String content, Reward reward) {
        this.postId = postId;
        this.username = username;
        this.community = community;
        this.content = content;
        this.createdAt = LocalDate.now();
        this.reward = reward;
    }

    public String getUsername() {
        return username;
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
