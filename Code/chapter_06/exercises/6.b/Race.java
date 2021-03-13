public class Race {
    private String name;
    private String result;
    private Car grid [];

    public Race(String name) {
        setName(name);
        setResult("Race not finished");
        createStartingGrid();
    }

    public void createStartingGrid() {
        Driver one = new Driver("Joey");
        Driver two = new Driver("Dee Dee");
        Driver three = new Driver("Johnny");
        Driver four = new Driver("Tommy");
        Car carNumberOne = new Car("Ferrari", one);
        Car carNumberTwo = new Car("Renault", two);
        Car carNumberThree = new Car("BMW", three);
        Car carNumberFour = new Car("Mercedes",  four);
        grid = new Car[4];
        grid[0] = carNumberOne;
        grid[1] =  carNumberTwo;
        grid[2] = carNumberThree;
        grid[3] =  carNumberFour;
    }

    public void runRace() {
        int winnerNumber = (int)(Math.random()*4);
        Car winner = grid[winnerNumber];
        String result = winner.getDetails();
        setResult(result);
    }

    public void setResult(String winner) {
        this.result = "Winner of " + this.getName()
        + ": " + winner;
    }

    public String getResult() {
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}