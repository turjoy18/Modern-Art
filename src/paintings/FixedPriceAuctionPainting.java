package paintings;

import players.Player;

public class FixedPriceAuctionPainting extends Painting {

    public FixedPriceAuctionPainting(int artist_id) {
        super(artist_id);
    }

    public String getType() {
        return "Fixed Price Auction";
    }

    @Override
    public void auction(Player[] players) {

//        System.out.println(this.owner.getName() + ", please fix a price for the auction");
//        int fixedPrice = this.owner.bid(currentBid, this);
//        System.out.println("The fixed price is " + fixedPrice);

        int fixedPrice = -1;


        while (fixedPrice < 0) {
            System.out.println(this.owner + ", please fix a price for the auction");
            fixedPrice = this.owner.bid(currentBid, this);
        }
        System.out.println("The fixed price is " + fixedPrice);

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

        for (int i = 0; i < players.length - 1; i++) {
            Player curr = players[ind];
            int bid = curr.bid(fixedPrice, this);
            System.out.println(curr.getName() + " bids " + bid);

            if (bid >= fixedPrice) {
                currentBid = fixedPrice;
                currentBidder = curr;
                paintingSold = true;
                break;
            }
            ind++;
            if (ind == players.length) {
                ind = 0;
            }
        }

        if (!paintingSold) {
            currentBidder = owner;
            currentBid = fixedPrice;
            sold();
        } else {
            sold();
        }

    }
}
