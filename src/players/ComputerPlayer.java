package players;
import paintings.Painting;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends Player {
    private int[][] scoreboard;
    private int compBid = 0;

    public ComputerPlayer(int money, int[][] scoreboard) {
        super(money, "Computer " + totalPlayers++);
        this.scoreboard = scoreboard;
    }

    public int bid(int currentBid, Painting painting) {
        int maxBid = evaluate(painting);
        int bound;

        if (painting.getType().equals("Open Auction")) {
//            if (this.getMoney() > currentBid) {
//                compBid = ThreadLocalRandom.current().nextInt(0, maxBid + 1);
////                if (compBid > currentBid)
////                    System.out.println(this.getName() + " bids " + compBid);
//                return compBid;
//            } else {
//                //System.out.println(this.getName() + " bids " + compBid);
//                return 0;
//            }
            bound = Math.min(maxBid + 1, this.getMoney() + 1);
            return (bound > 0) ? ThreadLocalRandom.current().nextInt(0, bound) : 0;

        } else if (painting.getType().equals("One Offer Auction")) {
//            compBid = ThreadLocalRandom.current().nextInt(0, maxBid + 1);
//            //System.out.println(this.getName() + " bids " + compBid);
//            return compBid;
            bound = maxBid + 1;
            return (bound > 0) ? ThreadLocalRandom.current().nextInt(0, bound) : 0;

        } else if (painting.getType().equals("Fixed Price Auction")) {
//            if (painting.getOwner() == this)
//                compBid = ThreadLocalRandom.current().nextInt(0, this.getMoney() + 1);
//            else
//                compBid = ThreadLocalRandom.current().nextInt(0, evaluate(painting));
//
//            if (compBid >= currentBid && painting.getOwner() != this)
//                compBid = currentBid;
//            return compBid;
            if (painting.getOwner() == this) {
                bound = this.getMoney() + 1;
            } else {
                bound = Math.min(evaluate(painting) + 1, this.getMoney() + 1);
            }
            return (bound > 0) ? ThreadLocalRandom.current().nextInt(0, bound) : 0;

        } else if (painting.getType().equals("Hidden Auction")) {
//            if (maxBid > getMoney())
//                compBid = ThreadLocalRandom.current().nextInt(0, getMoney() + 1);
//            else
//                compBid = ThreadLocalRandom.current().nextInt(0, maxBid + 1);
//            //System.out.println(this.getName() + " bids " + compBid);
//            return compBid;
            bound = Math.min(maxBid + 1, this.getMoney() + 1);
            return (bound > 0) ? ThreadLocalRandom.current().nextInt(0, bound) : 0;

        } else {
            return 0;
        }
    }

    private int evaluate(Painting painting) {
        int ind = painting.getArtistId();
        int maxBid = 30;

        for (int i = 0; i < scoreboard.length; i++) {
            for (int j = 0; j < scoreboard[i].length; j++) {
                if (j == ind) {
                    maxBid += scoreboard[i][j];
                    if (i == scoreboard.length - 1 && scoreboard[i][j] == 0)
                        maxBid = 30;
                }
            }
        }
        if (painting.getOwner() == this) {
            maxBid = maxBid / 2;
            if (maxBid > getMoney()) {
                return getMoney();
            } else {
                return maxBid;
            }
        }

        if (maxBid > getMoney()) {
            return getMoney();
        }
        return maxBid;
    }

    @Override
    public Painting playPainting() {
        Painting painting = handPaintings.get(ThreadLocalRandom.current().nextInt(0, handPaintings.size()));
        handPaintings.remove(painting);
        return painting;
    }

//    public String toString() {
//        return this.getName();
//    }
}
