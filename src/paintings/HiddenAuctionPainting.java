package paintings;

import players.Player;

public class HiddenAuctionPainting extends Painting {

    public HiddenAuctionPainting(int artist_id) {
        super(artist_id);
    }

    public String getType() {
        return "Hidden Auction";
    }

    @Override
    public void auction(Player[] players) {
        int[] bids = new int[players.length];
        int ownerInd = -1;

        for (int i = 0; i < players.length; i++) {
            if (players[i] == owner) {
                ownerInd = i;
                break;
            }
        }

        for (int i = 0; i < players.length; i++) {
            Player curr = players[i];
            bids[i] = curr.bid(0, this);
            System.out.println(curr.getName() + " bids " + bids[i]);
        }

        int highestBid = -1;
        int winningInd = -1;

        for (int i = 0; i < bids.length; i++) {
            if (bids[i] > highestBid) {
                highestBid = bids[i];
                winningInd = i;
            } else if (bids[i] == highestBid) {
                int distToOwnerCurr = (i - ownerInd + players.length) % players.length;
                int distToOwnerWin = (winningInd - ownerInd + players.length) % players.length;

                if (distToOwnerCurr < distToOwnerWin) {
                    winningInd = i;
                }
            }
        }

        if (highestBid == 0 || winningInd == -1) {
            currentBid = highestBid;
            currentBidder = owner;
        } else {
            currentBid = highestBid;
            currentBidder = players[winningInd];
        }

        sold();
    }
}
