public class Cat extends Animal {

    private static int count;

    public Cat(int animalDistanceRun, int animalDistanceSwim) {
        super(animalDistanceRun, animalDistanceSwim);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public boolean run(int distance) {
        if (distance < this.animalDistanceRun) {
            System.out.println("Кот пробежал %d метров%n", distance);
            return true;
        }
        System.out.println("Коту не удалось пробежать %d метров", distance);
        return false;
    }

    public boolean swim(int distance) {
        if (distance < this.animalDistanceSwim) {
            System.out.println("Кот проплыл %d метров%n", distance);
            return true;
        }
        System.out.println("Коту не удалось проплыть %d метров", distance);
        return false;
    }
}
