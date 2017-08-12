package com.PokerHand;

public class Card{
	
    private int value, suit;

    private static String[] suits = { "H", "S", "D", "C" };
    private static String[] values  = { "2", "3", "4", "5", "6", "7", 
                                       "8", "9", "10", "J", "Q", "K", "A"};
    Card(int i, int j)
    {
        this.value=j;
        this.suit=i;
    }

    public static String valueAsString( int __value ) {
        return values[__value];
    }

    //compares string input to suits and values of Card
    public static Card[] compare(String[] cardsnum){
    	
    	Card[] cards= new Card[5];
  	
    	for(int i=0;i<cardsnum.length;i++){
    		int j=0,k=0;
	    	for (j=0;j<values.length;j++) {
	    	    if (values[j].equals(String.valueOf(cardsnum[i].substring(0,cardsnum[i].length()-1)))) {
	    	    	break;
	    	    }
	    	}
	    	for (k=0;k<suits.length;k++) {
	    	    if (suits[k].equals(String.valueOf(cardsnum[i].charAt(cardsnum[i].length()-1)))) {
	    	    	break;
	    	    }
	    	}
	    	cards[i]=new Card(k,j);
    	}
    	return cards;
    }
    
    
    public int getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
   }
}