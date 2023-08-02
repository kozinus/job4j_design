package ru.job4j.serialization.json;

import ru.job4j.serialization.java.Contact;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    public boolean sex;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int age;

    @XmlElementWrapper(name = "infos")
    @XmlElement(name = "info")
    private String[] infos;

    private Contact contact;

    public Person() {

    }

    public Person(boolean sex, int age, String name, Contact contact, String... infos) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.infos = infos;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" + "sex=" + sex
                + ", name='" + name + '\''
                + ", age=" + age
                + ", info=" + Arrays.toString(infos)
                + ", contact=" + contact + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final Person person = new Person(false, 30, "Mark", new Contact(11, "11-111"), "Worker", "Married");

        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
