package com.PokerHand;

import java.util.Arrays;

public class Hand {
	private Card[] cards;
	private int[] value;

	Hand(){}
	Hand(Card[] cardt)
	{
		value = new int[6];// stores value for hand comparison 
		cards = new Card[5]; //stores card values
		for (int x=0; x<5; x++)
		{
			cards[x] = cardt[x];
		}

		int[] values = new int[5];
		boolean flush=true; 

		//checks for the flush
		for (int x=0; x<4; x++) {
			if ( cards[x].getSuit() != cards[x+1].getSuit() )
				flush=false;
		}
		
		
		for (int x=0; x<5; x++)
		{
			values[x]=cards[x].getValue();
		}
		Arrays.sort(values);
		int[] temp=new int[5]; 
		int i=0;
		for (int x=4; x>=0; x--)
		{
			temp[i]=values[x];i++;
		}
		for (int x=0; x<5; x++)
		{
			values[x]=temp[x];
		}

		
		//check the cards hand
		if (isStraightFlush(values,flush) == 8) {

		} else if (isFourOfAKind(values) == 7) {

		} else if (isFullHouse(values)== 6) {

		} else if (flush) {
			isFlush(values);
		} else if (isStraight(values)== 4) {

		} else if (isThreeOfAKind(values) == 3) {

		} else if (pairs(values) == 2) {

		} else if (pairs(values) == 1) {

		} else {
		    isHighCard(values);
		    value[0]=0;
		}
   
	}
	
	
	//finds and ranks the high card
	public void isHighCard(int[] values){
		for (int i = 0; i < 5; i++) {
			value[i+1]=values[i];
        	}
		
	}
	
	
	//finds single or double pairs in the card
	public int pairs(int[] values ) {
		int counter=0;
		for (int i = 0; i < 4; i++) {
				if (values[i] == values[i + 1]) {
					counter++;
					if (counter ==1){
						value[0]=1;
						value[1]=values[i];
					}
					if (counter ==2){
						value[0]=2;
						value[2]=values[i];
					}
				}
        	}
		int k=counter+1;
		for(int i=0; i<5;i++){
			if(counter==1 && values[i]!=value[1]){
				value[k]=values[i];
			}else if(counter==2 && values[i]!=value[1] && values[i]!=value[2]){
				value[k]=values[i];k++;
			}
				
		}

		return value[0];
	}

	
	//finds three of a kind	
	public int isThreeOfAKind(int[] values) {
       
		for (int i = 0; i < values.length - 2; i++) {
		    if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
			value[0] = 3;
					value[1]=values[i];
					break;
		    }
		}
		int k=2;
		if(value[0]==3){
			for (int j = 0; j < values.length; j++){
					if(values[j]!=value[1]) value[k]=values[j];k++;
			}
		}
        
        	return value[0];
   	 }	
	
	
	//finds if the card is straight
	public int isStraight(int[] values) {
        
		for (int i = 0; i < values.length - 1; i++){
		    if (values[i] == values[i + 1]+1) {
			value[0]=4;
		    }else {
					value[0]=0;
			break;
		    }

        	}
		if(value[0]==4){
			value[1]=values[0];
			for(int i=2;i<6;i++){
				value[i]=0;
			}
		}
        	return value[0];
    	}	
		
	
	//checks if it is Flush
	 public void isFlush(int[] values) {
		value[0]=5;
		isHighCard(values);

    	}	
	
	 
	//checks if the cards contain Full House
	public int isFullHouse(int[] values) {
		boolean one = false;
		boolean two = false;       
		value[0]=0;
            	if (values[0] == values[1] && values[1] == values[2]) {
                		one = true;
				value[1]=values[0];
            	}
		if (values[2] == values[3] && values[2] == values[4]) {
				one = true;
				value[1]=values[2];
            	}
		if (values[0] == values[1] && values[1] != values[2]) {
                		two = true;
				value[2]=values[0];
            	}
		if (values[4] == values[3] && values[2] != values[4]) {
                		two = true;
				value[2]=values[3];
            	}
		if(one && two){
				value[0]=6;
				for(int i=3;i<6;i++){
					value[i]=0;
				}
		}
		return value[0];
    }
		
	
	//Checks if the cards contain Four Of a Kind
	public int isFourOfAKind(int[] values) {

		for (int i = 0; i < values.length - 3; i++) {
		    if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
			value[0] = 7;
					value[1] = values[i];
					if(i+4<5){
						value[2]=values[4];
					}else{
						value[2]=values[0];
					}
					for(int j=3;j<6;j++){
						value[j]=0;
					}
		    }
		}
        	return value[0];
    }
		
	
	//Checks if the card is Straight Flush
	public int isStraightFlush(int[] values, boolean flush) {
			
			if (flush && isStraight(values) == 4) {
				value[0]=8;
			}

			return value[0];
	}

	
	//Displays the card hand based on Poker high value hand
	String display()
	{
		String s;
		switch( value[0] )
		{

			case 0:
				s="high card "+ Card.valueAsString(value[1]);
				break;
			case 1:
				s="pair of " + Card.valueAsString(value[1]) + "\'s";
				break;
			case 2:
				s="two pairs of " + Card.valueAsString(value[1]) + " and " + Card.valueAsString(value[2]);
				break;
			case 3:
				s="three of a kind " + Card.valueAsString(value[1]) + "\'s";
				break;
			case 4:
				s=Card.valueAsString(value[1]) + " high straight";
				break;
			case 5:
				s="flush";
				break;
			case 6:
				s="full house of " + Card.valueAsString(value[1]) + " over " + Card.valueAsString(value[2]);
				break;
			case 7:
				s="four of a kind " + Card.valueAsString(value[1]);
				break;
			case 8:
				s="straight flush of " + Card.valueAsString(value[1]);
				break;
			default:
				s="error in Hand.display: value[0] contains invalid value";
		}
		return s;
	}


	//Compares two Hand
	int compareTo(Hand that)
	{
		for (int x=0; x<6; x++)
		{
			if (this.value[x]>that.value[x])
				return 1;
			else if (this.value[x]<that.value[x])
				return -1;
		}
		return 0; //if hands are equal
	}
	
	
}


