public class HomeWork5 {
    public static void main(String[] args) {
        Person[] emp = new Person[5];
        emp[0] = new Person("Aa", "aa", "iiii@mailbox.com", "89007707070",50000,20);
        emp[1] = new Person("Aa", "bbb", "ffff@mail.com", "89007707073",40000,30);
        emp[2] = new Person("BB", "ccc", "dxxx@gmail.com", "89007707072",30000,19);
        emp[3] = new Person("Cc", "ddd", "fff@mail.ru", "89007707071",20000,44);
        emp[4] = new Person("Dd", "fff", "aaaa@mailbox.com", "89007707075",33100,50);
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
