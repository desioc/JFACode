public class HeadsOrTails {
    public String getHeadsOrTails() {
        EvenOrOdd evenOrOdd = new EvenOrOdd();
        String evenOrOddString = evenOrOdd.getEvenOrOdd();
        String headsOrTails = switch (evenOrOddString) {
            case "Even" -> "Heads";
            case "Odd" -> "Tails";
            default -> "There's a Bug!!!";
        };
        return headsOrTails;
    }
}