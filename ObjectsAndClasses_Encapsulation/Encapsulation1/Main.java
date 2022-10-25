package Encapsulation1;
public class Main {
        public static void main(String[] args) {
                Tank tank = new Tank("т34", 30, false);
                tank.setName("t50");
                tank.setMaxSpeed(50);
                tank.setSwim(true);
                System.out.println("Танк: " + tank.getName() + "\n" + "Скорость: " + tank.getMaxSpeed() + "\n" + "Плавает: " + tank.isSwim());
        }
}

