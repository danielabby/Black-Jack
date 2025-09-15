
public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		if ((getChips() > 500)){
			return 20;
		}
		if ((getChips() < 200)){
			return 5;
		}
		return 10; //always bet 10
	}

	@Override

	public Move getMove() {

		int score = handScore();
		int numAces = countAces();
		Card dealerCard = dealer.getVisibleCard();
		/* Hits until we get a score of 16 or better */
		if (score <= 16 && score >= 12){
			if (dealerCard.getRank() >= 7){
				return Move.HIT;
			}
			return Move.STAY;
		}

		if (numCards == 2 && numAces==1 && hasLowCard()) {
			return Move.HIT;
		}

		return Move.STAY;
	}

	@Override
	public void handOver(Card[] dealerHand) {

		
	}

	private int countAces(){
		int count = 0;
		for (int i =0; i<numCards; i++){
			if (cards[i] != null && cards[i].getRank() == 1){
				count++;
			}
		}
		return count;
	}

	private boolean hasLowCard(){
		for (int i = 0; i < numCards; i++){
			if (cards[i]!=null){
				int rank = cards[i].getRank();
				if(rank>=2 && rank<=6){
					return true;
				}
			}
		}
		return false;
	}

	
}
