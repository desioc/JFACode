public class TrafficLightTest2 {
    public static void main(String args[]) {
        TrafficLight2 trafficLight = new TrafficLight2();
        trafficLight.changeColor(Color2.RED);
        trafficLight.printState();
        trafficLight.changeColor(Color2.YELLOW);
        trafficLight.printState();
        trafficLight.changeColor(Color2.GREEN);
        trafficLight.printState();
        trafficLight.changeColor(Color2.BLACK);
        trafficLight.printState();
    }
}