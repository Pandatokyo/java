public class HomeWork {

    public static void main(String[] args) {
        Animal[] animals = makeAnimals();
        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(20);
        }
    // проверка функций
        System.out.println("Количество котов:" Cat.getCount());
        System.out.println("Количество собак:" Dog.getCount());
        System.out.println("Количество всех животных:" Animal.getCount());
}
