package br.edu.ifsp.poo.practical01;

public class Principal {
    public static void main(String[] args) {
        UserAccount jao = new UserAccount("jao@email.com", "jao");
        UserAccount lucas = new UserAccount("lucas@email.com", "lucas");
        UserAccount nat = new UserAccount("nat@email.com", "nat");
        UserAccount laura = new UserAccount("laura@email.com", "laura");

        jao.acceptFollower(nat);
        jao.acceptFollower(laura);

        jao.publish("Palmeiras não tem mundial1");
        jao.publish("Palmeiras não tem mundial2");
        jao.publish("Palmeiras não tem mundial3");
        jao.publish("Palmeiras não tem mundial4");
        jao.publish("Palmeiras não tem mundial5");
        jao.publish("Palmeiras não tem mundial6");
        jao.publish("Palmeiras não tem mundial7");
        jao.publish("Palmeiras não tem mundial8");
        jao.publish("Palmeiras não tem mundial9");
        jao.publish("Palmeiras não tem mundial10");
        jao.publish("Palmeiras não tem mundial11");

        System.out.println("Followers do Jão:");
        System.out.println(jao.getFollowersAsString());

        jao.blockFollower(nat);

        System.out.println("Followers do Jão (depois de brigar com a Nat):");
        System.out.println(jao.getFollowersAsString());

        System.out.println("Followers da Nat:");
        System.out.println(nat.getFollowersAsString());



        jao.deletePost(-1);
        jao.deletePost(0);
        jao.deletePost(1);
        jao.deletePost(9);
        jao.deletePost(10);
        System.out.println("My posts do Jão:");
        System.out.println(jao.getMyPostsAsString());

        System.out.println("Timeline do Jão:");
        System.out.println(jao.getTimelineAsString());

        nat.booPost(4);
        nat.clapPost(5);
        nat.booPost(4);

        System.out.println("Timeline do Nat:");
        System.out.println(nat.getTimelineAsString());


        System.out.println("Timeline do Lucas:");
        System.out.println(lucas.getTimelineAsString());



    }
}
