# Modern Art - Auction Game

Modern Art is a Java-based auction game where players bid on paintings, aiming to maximize their profits through strategic bidding and sales.

# Understanding the Game
1. Objective
The player with the most money at the end of the game wins. Money is earned by buying and selling paintings, and the values of the paintings are based on how popular each artist becomes in each round.

2. Game Setup
Each player receives a set of cards representing paintings by different artists.
The artists are represented by five different colors or symbols, which players use to track popularity.
Players also receive an amount of starting money.
3. Gameplay Overview
The game is played over four rounds. Each round, players will auction paintings, and the value of an artist’s paintings increases based on how often their art is sold during the round. At the end of each round, the most popular artists’ paintings will have a higher payout value.

4. Auction Types
The game includes four auction types, each with specific rules:

Open Auction: Players freely bid until no higher bids are placed.
One-Round Auction: Each player gets one chance to bid, going around in turn.
Fixed-Price Auction: The seller sets a price, and the first player to accept pays and wins the painting.
Hidden Auction: Players secretly select a bid amount, revealing them simultaneously. The highest bid wins.
Each painting card specifies which auction type is used.

5. Rounds and Artist Popularity
Players take turns auctioning one painting at a time.
A round ends once five paintings by any one artist have been auctioned.
At the end of each round, the three most popular artists’ paintings increase in value.
The value of each artist’s paintings from the current and previous rounds is calculated, and players get payouts for the paintings they own.
6. End of the Game
After four rounds, the game ends, and the players receive final payouts for all paintings they hold based on the artists’ popularity.
The player with the most money wins.

## Features
- Supports multiple players.
- Various auction types, including Open Auction.
- Players start with an initial amount of money and bid for paintings.
- Automatic validation for bid amounts and auction rules.

## Requirements
- Java 8 or higher

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/turjoy18/ModernArt.git
   ```
2. Navigate to the project directory:
   ```sh
   cd ModernArt
   ```
3. Compile the Java files:
   ```sh
   javac *.java
   ```
4. Run the game:
   ```sh
   java ModernArt
   ```

## How to Play
1. Players take turns selecting a painting to auction.
2. The auction follows a round-robin format where players bid.
3. The highest bidder wins the painting and pays the amount.
4. At the end of the round, paintings are sold based on their final value.
5. The player with the most money at the end wins!

## Project Structure
- `ModernArt.java` - Main game logic.
- `Player.java` - Manages player actions and bidding.
- `Painting.java` - Represents the paintings in the game.

## Contributing
Feel free to submit issues or pull requests to improve the project!

## License
This project is licensed under the MIT License.

