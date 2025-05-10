    /**
	* The Deck class is used to create decks using cards from the Card class.
	* @author Olivia Su
	* @version Problem Set Unit 4
	*/

    class Deck {

        //instance variables
        private Card[] deck;


        /**
         * Constructs the deck.
         * @param deck a Card array that holds cards
         */
        public Deck(Card[] deck) {

            if(deck == null || deck.length == 0){
                this.deck = new Card[0];
            }else{
                this.deck = deck;
            }
            // if deck is null or empty set deck as empty array
            // sets an array of cards(parameter) as the deck

        }

        /**
         * Constructs a default deck that holds cards with a name, suit and value, there are 52 cards.
         */
        public Deck(){   
            String[] name = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
            String[] suit = {"hearts", "clubs", "diamonds", "spades"};
            int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
            //makes arrays for the values of name, suit and value of the card

            this.deck = new Card[52];
            int currentIndex = 0;
            // creates an array that can hold 52 cards
            // create a counter for what card you are currently on

            for(int i = 0; i < suit.length; i++){
                for(int j = 0; j < name.length; j++){
                    this.deck[currentIndex] = new Card(name[j], suit[i], value[j]);
                    currentIndex = currentIndex +1;

                    // this deck is an array, adds a new card object with the values of name suit and value
            
                }

            }

        }

     
        /**
	     * Get's the deck's size.
	     *@return returns a integer of how many cards are in the deck  
	     */
        public int size(){
            return this.deck.length;
        }
        

        /**
	     *Get's the deck.
	     *@return returns a object which is the top card of the deck
	     */
        public Card draw(){

            if(deck == null || deck.length == 0){
                return null;
            }
            // if deck is null or empty return null

            Card topCard = this.deck[this.deck.length -1];
            // stores the top card into the variable topCard

            Card[] remainCards = new Card[this.deck.length-1];
            // an array that holds the cards other than the top card

		    for (int i = 0; i < this.deck.length; i++) {
			    remainCards[i] = this.deck[i]; 
                // takes the cards that are left(all cards but top card) and sets them as the remaining cards
		    }

            this.deck = remainCards;
            return topCard;
            // make the new deck the remaining cards
        
        }
        

        /**
	     *shuffles the cards in the deck, does not return anything.
	     */
        public void shuffle(){

            for (int i = 0; i < this.deck.length; i++) {
                int j = (int)(Math.random() * (i + 1));
                // for loop ensures every card gets shuffled
                // generates a random index between j and i
                    Card temp = this.deck[i];
                    this.deck[i] = this.deck[j];
                    this.deck[j] = temp;
                    // swap the card at deck[j] and the card at deck[i]
                    
            }
            
        }
}
