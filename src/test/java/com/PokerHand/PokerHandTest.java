package com.PokerHand;

import static org.junit.Assert.*;


import org.junit.Test;

public class PokerHandTest {

	@Test
	public void Detect_HighCard() {
		
	  String Player = "AH 2D 9C KS JS";
	  Card[] cards1 = new Card[5];
  	  cards1=Card.compare(Player.split(" "));  
  	  Hand h1 = new Hand(cards1);
  	  assertEquals("high card A",h1.display());
  	  
	  Player = "9H 2D 5C 10S 3S";
  	  cards1=Card.compare(Player.split(" "));  
  	  h1 = new Hand(cards1);
  	  assertEquals("high card 10",h1.display());
	}

	@Test
	public void Detect_Pairs() {
		
		  String Player = "AH AD 9C KS JS";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("pair of A's",h1.display());
	  	  
		  Player = "9H 9D 5C 5S 3S";
	  	  cards1=Card.compare(Player.split(" "));  
	  	  h1 = new Hand(cards1);
	  	  assertEquals("two pairs of 9 and 5",h1.display());
	}
	
	@Test
	public void Detect_isThreeOfAKind() {
		
		  String Player = "2H 2D 9C 2S JS";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("three of a kind 2's",h1.display());
	  	  
	}
	
	@Test
	public void Detect_isStraight() {
		
		  String Player = "2H 3D 4C 5S 6S";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("6 high straight",h1.display());
	  	  
	}
	
	@Test
	public void Detect_isFlush() {
		
		  String Player = "2H 3H 9H 5H KH";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("flush",h1.display());
	  	  
	}
	
	@Test
	public void Detect_isFullHouse() {
		
		  String Player = "2H 3H 2S 3C 2D";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("full house of 2 over 3",h1.display());	  	  
	}
	
	@Test
	public void Detect_isFourOfaKind() {
		
		  String Player = "JH 3H JS JC JD";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("four of a kind J",h1.display());	  	  
	}
	
	@Test
	public void Detect_isStraightFlush() {
		
		  String Player = "8H 9H 10H JH QH";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  assertEquals("straight flush of Q",h1.display());	  	  
	}
	
	@Test
	public void player_1_shouldwinWith_pairofJacks() {
		
		  String Player = "8H 9H JD JH QH";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  
	  	  Player = "8H 9H 2D JH QH";
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h2 = new Hand(cards1);
	  	  assertEquals(1,h1.compareTo(h2));	  	  
	}
	

	@Test
	public void player_2_shouldwinWith_flush() {
		
		  String Player = "8H 9H JD JH QH";
		  Card[] cards1 = new Card[5];
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h1 = new Hand(cards1);
	  	  
	  	  Player = "8H 9H 10H JH QH";
	  	  cards1=Card.compare(Player.split(" "));  
	  	  Hand h2 = new Hand(cards1);
	  	  assertEquals(1,h2.compareTo(h1));	
	  	  
	}
}
