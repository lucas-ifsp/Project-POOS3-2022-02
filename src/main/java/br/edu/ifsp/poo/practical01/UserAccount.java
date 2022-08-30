package br.edu.ifsp.poo.practical01;

import javafx.geometry.Pos;

public class UserAccount {
    public static final int MAX_ARRAY_SIZE = 100;
    private final String email;
    private String username;

    private final Post[] timeline = new Post[10];
    private final Post[] myPosts = new Post[MAX_ARRAY_SIZE];
    private final UserAccount[] followers = new UserAccount[MAX_ARRAY_SIZE];

    private int numPosts;
    private int numPostsTimeline;
    private int numFollowers;

    public UserAccount(String email, String username){
        this.email = email;
        this.username = username;
    }

    public void publish(String quote){
        Post post = new Post(quote, this);
        myPosts[numPosts++] = post;
        for (int i = 0; i < numFollowers; i++) {
             followers[i].updateTimeline(post);
        }
    }

    public void clapPost(int index){
        if(index < 0 || index >= Math.min(numPostsTimeline, timeline.length)) return;
        timeline[index].clap();
    }

    public void booPost(int index){
        if(index < 0 || index >= Math.min(numPostsTimeline, timeline.length)) return;
        timeline[index].boo();
    }

    public void deletePost(int index){
        if(index < 0 || index >= numPosts) return;

        for(int i = index; i < numPosts - 1; i++){
            myPosts[i] = myPosts[i+1];
        }
        myPosts[numPosts--] = null;
    }

    public void blockFollower(UserAccount follower){
        for (int i = 0; i < numFollowers; i++) {
            if(followers[i] == follower){
                for(int j = i; j < numFollowers - 1; j++){
                    followers[j] = followers[j+1];
                }
                followers[numFollowers--] = null;
            }
        }
        myPosts[numPosts--] = null;
    }
    private void updateTimeline(Post post){
        timeline[numPostsTimeline % 10] = post;
        numPostsTimeline++;
    }

    public void acceptFollower(UserAccount follower){
        followers[numFollowers++] = follower;
    }

    //In the test, this method is named showTimeline
    public String getTimelineAsString(){
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Math.min(timeline.length, numPostsTimeline); i++) {
            builder.append(timeline[i].getPostInfo()).append("\n");
        }
        return builder.toString();
    }

    //In the test, this method is named showMyPosts
    public String getMyPostsAsString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numPosts; i++) {
            result.append(myPosts[i].getPostInfo()).append("\n");
        }
        return result.toString();
    }

    //In the test, this method is named showFollowers
    public String getFollowersAsString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numFollowers; i++) {
            UserAccount follower = followers[i];
            String userInfo = "Username: " + follower.username + " | E-mail: " + follower.email;
            result.append(userInfo).append("\n");
        }
        return result.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
