public abstract class Animal {
    protected int animalDistanceRun, animalDistanceSwim;
    private static int count;

    Animal(double animalDistanceRun, double animalDistanceJump, double animalDistanceSwim) {
        this.animalDistanceRun = animalDistanceRun;
        this.animalDistanceSwim = animalDistanceSwim;
        count++;
    }

    public abstract boolean run(int distance);
    public abstract boolean swim(int distance);

    public static int getCount() {
        return count;
    }
}
