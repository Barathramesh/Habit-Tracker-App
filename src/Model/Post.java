package Model;

import java.time.LocalDate;

public class Post {
    private int postId;
    private final String username;
    private Community community;
    private Reward reward;
    private final String content;
    private final LocalDate createdAt;

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
        this.reward = reward;
        this.content = content;
        this.createdAt = LocalDate.now();
    }

    public String getUsername() {
        return username;
    }

    public Reward getReward() {
        return reward;
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
