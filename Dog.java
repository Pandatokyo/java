class Dog extends Animal {

    private static int count;

    public Dog(int animalDistanceRun, int animalDistanceSwim) {
        super(animalDistanceRun, animalDistanceSwim);
        count++;
    }

    public static int getCount() {
        return count;
    }


    public boolean run(int distance) {
        if (distance < this.animalDistanceRun) {
            System.out.println("Собака пробежала %d метров%n", distance);
            return true;
        }
        System.out.println("Собаке не удалось пробежать %d метров", distance);
        return false;
    }

    public boolean swim(int distance) {
        if (distance < this.animalDistanceSwim) {
            System.out.println("Собака проплыла %d метров%n", distance);
            return true;
        }
        System.out.println("Собаке не удалось проплыть %d метров", distance);
        return false;
    }
}