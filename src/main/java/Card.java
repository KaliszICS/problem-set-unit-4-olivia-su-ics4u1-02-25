    /**
	* The Card class is used to create cards.
	* @author Olivia Su
	* @version Problem Set Unit 4, Not sure what java version this is
	*/

    class Card {

        //instance variables
        private String name;
        private String suit;
        private int value;
    
        /**
         * Constructs the card's name, suit and value.
         * @param name a string that represents the rank of the card
         * @param suit a string that represents the suit of the card
         * @param value a interger that represents the value of the card
         */
        public Card(String name, String suit, int value) {
            this.name = name;
            this.suit = suit;
            this.value = value;
        }
    

        //getters

        /**
         * Gets the card's rank.
         * @returns returns a string of the card's ranks
         */
        public String getName() {
            return this.name;
        }
        

        /**
         * Gets the card's suit.
         * @returns returns a string of the card's suit
         */
        public String getSuit() {
            return this.suit;
        }
    

        /**
         * Gets the card's value.
         * @returns returns a interger of the card's value
         */
        public int getValue() {
            return this.value;
        }
        

        /**
	     * Get's the card's rank and suit.
	     *@return returns a string of the card's rank and suit in the format: name of suit  
	     */
        public String toString(){
            return this.name + " of "+ this.suit;
        }
	    
    
        /**
	     *Get's the card's rank, suit and value.
	     *@return returns a boolean true, if the card's rank, suit and value are the same as the current card's rank, suit, and value (they are the same card)  
	     *@return returns a boolean false, if the card's rank, suit and value are not the same as the current card's rank, suit, and value (they are not the same card)
         *@return returns a boolean false, if there is no object to compare to (null) or the object being compared isn't the same class as the card
         */
        public boolean equals(Object obj){
            if (obj == null || obj.getClass() != this.getClass()){
                return false;
            }
            Card card = (Card)obj;
            if ((card.getName().equals(this.name)) && (card.getSuit().equals(this.suit)) && (card.getValue() == (this.value))) {
                return true;
            }
            return false;
        }
        //Hi Mr.K :3
        
    }