package Encapsulation1;
public class Tank {
    private String name;
    private int maxSpeed;

    public Tank(String name, int maxSpeed, boolean swim) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.swim = swim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isSwim() {
        return swim;
    }

    public void setSwim(boolean swim) {
        this.swim = swim;
    }

    private boolean swim;
}
