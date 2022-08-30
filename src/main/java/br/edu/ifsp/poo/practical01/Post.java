package br.edu.ifsp.poo.practical01;

import java.time.LocalDateTime;

public class Post {
    private final String quote;
    private final UserAccount userAccount;
    private final LocalDateTime timestamp;
    private int claps;
    private int boos;

    public Post(String quote, UserAccount userAccount) {
        this.quote = quote;
        this.userAccount = userAccount;
        this.timestamp = LocalDateTime.now();
    }

    //In the test, the name is show()
    public String getPostInfo(){
        return String.format("[%s] %s says \"%s\" | Claps: %d | Boos: %d",
                timestamp, userAccount.getUsername(), quote, claps, boos);
    }

    public void boo(){
        boos++;
    }

    public void clap(){
        claps++;
    }

    public String getQuote() {
        return quote;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getClaps() {
        return claps;
    }

    public int getBoos() {
        return boos;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
}
