public class CoinsTest {
    public static void main(String args[]) {
        Coin twentyCentsCoin = new Coin(Value.TWENTY_CENTS);
        Coin oneCentCoin = new Coin(Value.ONE_CENT);
        Coin oneEuroCoin = new Coin(Value.ONE_EURO);
        // Creation of a Purse with 11 coins
        Purse purseToFail = new Purse(Value.TWO_CENTS, Value.FIVE_CENTS, Value.ONE_EURO, Value.TEN_CENTS,
        Value.FIFTY_CENTS, Value.TEN_CENTS, Value.ONE_EURO, Value.TWO_EURO, Value.TEN_CENTS, Value.FIVE_CENTS, Value.TWO_CENTS);
        // Creation of a Purse with 8 coins
        Purse purse = new Purse(Value.TWO_CENTS, Value.FIVE_CENTS, Value.ONE_EURO, Value.TEN_CENTS,
                Value.FIFTY_CENTS, Value.TEN_CENTS, Value.ONE_EURO, Value.TWO_EURO);
        purse.state();

        try {
            // we add a 20 cents coin
            purse.add(twentyCentsCoin);
        } catch (FullPurseException | NullCoinException exc) {
            System.out.println(exc.getMessage());
        }

        try {
            // we add a 1 cents coin
            purse.add(oneCentCoin);
        } catch (FullPurseException | NullCoinException exc) {
            System.out.println(exc.getMessage());
        }

        try {
            // We add the eleventh coin (we should get an error and the
        // coin will not be added)
            purse.add(oneEuroCoin);
        } catch (FullPurseException | NullCoinException exc) {
            System.out.println(exc.getMessage());
        }

        // We evaluate the status of the purse
        purse.state();

        try {
            // we withdraw 20 cents
            purse.withdraw(twentyCentsCoin);
        } catch (CoinNotFoundException exc) {
            System.out.println(exc.getMessage());
        }

        try {
            //Let's add the tenth coin again
            purse.add(oneEuroCoin);
        } catch (FullPurseException | NullCoinException exc) {
            System.out.println(exc.getMessage());
        }

        // We evaluate the status of the purse
        purse.state();

//The next example has no sense now!
//        try {
//        // We withdraw a non-existent currency (we should get an error)
//            purse.withdraw(new Coin(7));
//        } catch (CoinNotFoundException exc) {
//            System.out.println(exc.getMessage());
//        }

        try {
            //We try to add null
            purse.add(null);
        } catch (FullPurseException | NullCoinException exc) {
            System.out.println(exc.getMessage());
        }

        try {
            //We try to withdraw null
            purse.withdraw(null);
        } catch (CoinNotFoundException | NullCoinException exc) {
            System.out.println(exc.getMessage());
        }
        //we test the passage of the null value to the purse constructor
        Purse purseWithNullPointerException = new Purse(null);
        purse.state();
    }
}