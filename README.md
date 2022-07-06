# freecell-solitaire
Code that renders a game of Freecell Solitaire. 
Play starts by dealing the full deck of 52 cards among the cascade piles, in a round-robin fashion (e.g. in a game with eight cascade piles, pile 1 will have card indices 0, 8, 16,..., pile 2 will have card indices 1, 9, 17, ... and so on (assuming card indices in the deck begin at 0). 
The player then moves cards between piles, obeying the rules above. 
The objective of the game is to collect all cards in the four foundation piles, at which stage the game is over.

The toString method of this class returns a String which may be used to print the board, in the format illustrated below. 
The details of the output are described in the Javadoc for this method in the provided FreecellView interface. 
The following shows the output:
     F1: A♠
     F2: A♣, 2♣
     F3: A♥, 2♥
     F4:
     O1:
     O2:
     O3:
     O4: 8♦
     C1: K♠, 3♦, K♥, 8♠, 5♥, 5♦, 5♠
     C2: 4♣, 5♣, 4♠, 9♦, K♣
     C3: 2♠, 9♠, 8♣, 10♦, 8♥, Q♠, J♦
     C4: 10♥, J♠, Q♦, 6♣, 3♣, J♣
     C5: 6♦, 3♥, 10♠, Q♥, 6♠
     C6: 9♣, 7♣, 7♥, K♦, 4♥, 3♠, 2♦
     C7: Q♣, J♥, 10♣, 9♥
     C8: 7♦, 7♠, 6♥, A♦, 4♦
