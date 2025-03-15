package paintings;

import players.Player;

public class OneOfferAuctionPainting extends Painting {

    public OneOfferAuctionPainting(int artist_id) {
        super(artist_id);
    }

    public String getType() {
        return "One Offer Auction";
    }

    @Override
    public void auction(Player[] players) {
        int ownerInd = 0;
        int ind = 0;
        boolean paintingSold = false;

        for (int i = 0; i < players.length; i++) {
            if (players[i] == owner) {
                ownerInd = i;
                break;
            }
        }

        if (ownerInd != players.length - 1)
            ind = ownerInd + 1;

        for (int i = 0; i < players.length; i++) {
            Player curr = players[ind];
            int bid = curr.bid(currentBid, this);
            System.out.println(curr.getName() + " bids " + bid);

            if (bid > currentBid) {
                currentBid = bid;
                currentBidder = curr;
                paintingSold = true;
            }
            ind++;
            if (ind == players.length) {
                ind = 0;
            }
        }

        if (!paintingSold) {
            currentBidder = owner;
            currentBid = 0;
            sold();
        } else {
            sold();
        }
    }
}
