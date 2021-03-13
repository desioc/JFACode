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
        // we add a 20 cents coin
        purse.add(twentyCentsCoin);
        // We evaluate the status of the purse
        purse.state();
        // we take 20 cents
        purse.withdraw(twentyCentsCoin);
    }
}