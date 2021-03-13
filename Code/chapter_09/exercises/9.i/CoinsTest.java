/**
 * Test classe for the Coin and Purse classes.
 * 
 * @author Claudio De Sio Cesari
*/
public class CoinsTest {
    public static void main(String args[]) {
        Coin twentyCentsCoin = new Coin(20);
        Coin oneCentCoin = new Coin(1);
        Coin oneEuroCoin = new Coin(100);
        // Creation of a Purse with 11 coins
        Purse purseToFail = new Purse(2, 5, 100, 10,
            50, 10, 100, 200, 10, 5, 2);
        // Creation of a Purse with 8 coins
        Purse purse = new Purse(2, 5, 100, 10, 50, 10, 100,
            200);
        purse.state();
        // we add a 20 cents coin
        purse.add(twentyCentsCoin);
        // we add a 1 cents coin
        purse.add(oneCentCoin); 
        // We add the eleventh coin (we should get an error and the
        // coin will not be added)
        purse.add(oneEuroCoin); 
        // We evaluate the status of the purse
        purse.state();
        // we withdraw 20 cents
        purse.withdraw(twentyCentsCoin);
        //Let's add the tenth coin again
        purse.add(oneEuroCoin); 
        // We evaluate the status of the purse
        purse.state();
        // We withdraw a non-existent currency (we should get an error)
         purse.withdraw(new Coin(7));
    }
}