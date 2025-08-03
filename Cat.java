import java.util.Random;

public class Cat {
    private String name;
    private double hearts;
    private int fish;
    private boolean isTame;
    private boolean isAlive;
    private Random random;

    public Cat(String name) {
        this.name = name;
        this.hearts = 2.0;
        this.fish = 0;
        this.isTame = false;
        this.isAlive = true;
        this.random = new Random();
    }

    private void updateHearts(double amount) {
        hearts += amount;
        if (hearts <= 0) {
            hearts = 0.0;
            isAlive = false;
            System.out.println(name + " has no hearts left and has died!\n");
        } else if (hearts > 4.0) {
            hearts = 4.0;
        }
    }

    private void updateFish(int amount) {
        fish += amount;
        if (fish < 0) {
            fish = 0;
        } else if (fish > 3) {
            isAlive = false;
            hearts = 0.0;
            System.out.println("You overfed " + name + "! They died!\n");
        }
    }

    public void feed() throws Exception {
        if (!isAlive) {
            throw new Exception(name + " is already dead, you cannot feed it!\n");
        }
        System.out.println(name + " has been fed!\n");
        updateHearts(1.0);
        updateFish(1);
        if (random.nextInt(2) == 1) {
            isTame = true;
        }
    }

    public void hit() {
        if (hearts > 0.0) {
            updateHearts(-1.5);
        }
        isTame = false;
    }

    public void night() {
        if (isTame && fish >= 1 && isAlive) {
            System.out.println(name + " has left you a gift!\n");
        }
        if (isAlive) {
            updateFish(-1);
        }
        if (fish == 0) {
            isTame = false;
        }
    }

    @Override
    public String toString() {
        String state = isTame ? "Tame" : "Wild";
        String life = isAlive ? "Alive" : "Dead";
        return String.format("%s is %s and %s, with %.1f hearts and %d fish.", name, life, state, hearts, fish);
    }
}
