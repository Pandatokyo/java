public class HomeWork5 {
    public static void main(String[] args) {
        Person[] emp = new Person[5];
        emp[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",50000,41);
        emp[1] = new Person("Petrov Petr", "Creator", "petrov@mailbox.com", "892312314",50000,32);
        emp[2] = new Person("Sidorov Sidr", "Water pot", "sidorov@mailbox.com", "892312315",10000,43);
        emp[3] = new Person("Pupkina Nadegda", "EnvelopeLicker", "pupkina@mailbox.com", "892312316",5000,18);
        emp[4] = new Person("Juk J", "GrinderPencil", "juk@mailbox.com", "892312317",3000,21);
        for (Person i : emp)
            if (i.getAge() > 40)
                System.out.println(i);

    }
}
class Person {
    private String full_name;
    private String job;
    private String email;
    private String phone;
    private int wages;
    private int age;

    public Person(String full_name, String job, String email, String phone, int wages, int age) {
        this.full_name = full_name;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.wages = wages;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        // как можно по другому вывести несколько значений?
        return (full_name+"\n"+job+"\n"+email+"\n"+phone+"\n"+wages+"\n"+age);
    }
}
