public class Purse {

    private static final int DIMENSION = 10;
    private final Coin[] coins = new Coin[DIMENSION];

    public Purse(Value... values) {
        assert coins.length == DIMENSION;
        try {
            int numberOfCoins = values.length;
            for (int i = 0; i < numberOfCoins; i++) {
                if (i >= 10) {
                    throw new FullPurseException (
                        "Only the first 10 coins have been inserted!");
                }
                coins[i] = new Coin(values[i]);
            }
    //  } catch (FullPurseException | NullPointerException exc) {
        } catch (FullPurseException exc) {
            System.out.println(exc.getMessage());
        } catch (NullPointerException exc) {
            System.out.println("The purse has been created empty");
        }
        assert coins.length == DIMENSION;
    }

    public void add(Coin coin) throws FullPurseException {
        try {
            System.out.println("Let's try adding one "+
            coin.getDescription());
        } catch (NullPointerException exc) {
            throw new NullCoinException();
        }
        int freeIndex = firstFreeIndex();
        if (freeIndex == -1) {
            throw new FullPurseException("Purse full! The coin "
            + coin.getDescription() +" has not been added!");
        } else {
            coins[freeIndex] = coin;
            System.out.println(coin.getDescription() +" has been added");
        }
    }

    public Coin withdraw(Coin coin) throws CoinNotFoundException {
        try {
            System.out.println("Let's try to get a "+
                    coin.getDescription());
        } catch (NullPointerException exc) {
            throw new NullCoinException();
        }
        Coin foundCoin = null;
        int foundCoinIndex = foundCoinIndex(coin);
        if (foundCoinIndex == -1) {
            throw new CoinNotFoundException("Coin not found!");
        } else {
            foundCoin = coin;
            coins[foundCoinIndex] = null;
            System.out.println("One "+ coin.getDescription() +" withdraw");
        }
        return foundCoin;
    }

    public void state() {
        System.out.println("The purse contains:");
        for (Coin coin : coins) {
            if (coin == null) {
                break;
            }
            System.out.println("One "+ coin.getDescription());
        }
    }
    
    private int firstFreeIndex() {
        int index = -1;
        for (int i = 0; i < 10; i++) {
            if (coins[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int foundCoinIndex(Coin coin) {
        int foundCoinIndex = -1;
        for (int i = 0; i < 10; i++) {
            if (coins[i] == null) {
                continue;
            }
            Value coinInPurseValue = coins[i].getValue();
            Value value = coin.getValue();
            if (value == coinInPurseValue) {
                foundCoinIndex = i;
                break;
            }
        }
        return foundCoinIndex;
    }
}