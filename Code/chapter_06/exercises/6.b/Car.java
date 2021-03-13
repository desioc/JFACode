public class Car {
    private String stable;
    private Driver driver;

    public Car(String stable, Driver driver) {
      setStable(stable);
      setDriver(driver);
    }
    public void setStable(String stable) {
      this.stable = stable;
    }
    public String getStable() {
      return stable;
    }
    public void setDriver(Driver driver) {
      this.driver = driver;
    }
    public Driver getDriver() {
      return driver;
    }
    public String getDetails() {
      return getDriver().getName() + " on "+ getStable();
    }
  }