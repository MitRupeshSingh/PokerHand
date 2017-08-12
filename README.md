# PokerHand
Poker Hand Java Code With Test Java File


It is a poker hand project where input is taken from user in the form of "AH 2D 8S JD KD".
Each player is provided 5 cards.

We created 3 class: Card, Game and Hand.

1. Card does all the processing related to cards like extracting suites and values of cards from input given by user.

2. Hand does all the processing like finding the top hands among cards of different players using different functions.
   Each hand is given a value based on the rank.
   Straight Flush : 8
   Four Of a Kind: 7
   Full House: 6
   Flush: 5
   Straight: 4
   Three of a kind: 3
   Two pairs: 2
   A pair: 1
   High Card: 0
   
3. Game is the main class which takes input from the user for different players and perform all the comparison of the cards. 

Finally, we have PokerHandTest file which test different conditions for our project.
