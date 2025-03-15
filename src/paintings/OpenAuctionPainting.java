package paintings;

import players.Player;

public class OpenAuctionPainting extends Painting {

    public OpenAuctionPainting(int artist_id) {
        super(artist_id);
    }

    public String getType() {
        return "Open Auction";
    }

    public void auction(Player[] players) {
        do {
            for (Player p : players) {
                if (p == currentBidder) {
                    //he won the auction;
                    sold();
                    return;
                }
                int offer = p.bid(currentBid, this);
                System.out.println(p.getName() + " bids " + offer);
                if (offer > currentBid) {
                    bid(offer, p);
                }
            }
        } while (currentBidder != null);
        sold();
    }
    private boolean bid(int value, Player p) {
        if (currentBidder == null || value > currentBid && p != currentBidder && p.getMoney() >= value) {
            currentBid = value;
            currentBidder = p;
            return true;
        }
        return false;
    }
}
