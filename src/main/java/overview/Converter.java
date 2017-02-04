package overview;

/**
 * Created by adrian on 10.12.16.
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Demo {
    public static void main (String... args) {

        // Functional Interfaces
        Converter<Integer, String> c = Object::toString;
        System.out.println(c.convert(22));

        // Method references
        Etwas e = new Etwas();
        Converter<String, String> c2 = e::startsWith;
        System.out.println(c2.convert("Hallo"));


        // Construcor references
        PersonFactory<Person> pf = Person::new;
        Person person = pf.create("Max", "Muster");
        System.out.println(person.firstName + " "  + person.lastName);


    }


}
class Etwas {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

class Person {
    String firstName;
    String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}