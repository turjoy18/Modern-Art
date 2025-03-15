package players;

import paintings.Painting;

public class AFKPlayer extends Player {

//    public AFKPlayer(int money, String name) {
//        super(money, name);
//    }

    public AFKPlayer(int money) {
        super(money, "AFK " + totalPlayers++);
    }

    public int bid(int currentBid, Painting p) {
        return 0;
    }

    public Painting playPainting() {
        Painting painting = handPaintings.get(0);
        handPaintings.remove(0);
        return painting;
    }

//    public String toString() {
//        return this.getName() + " has $" + this.getMoney();
//    }
}
