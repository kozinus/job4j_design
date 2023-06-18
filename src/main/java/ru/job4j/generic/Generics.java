package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        generics.printBoundedWildCard(first);
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        generics.printLowerBoundedWildCard(third);
    }

    /*
    метод не может принимать список с объектами одного класса Object,
    поэтому нужно применить wildcard и заменить обобщение на <?>
     */
    public void printObject(List<?> list) {
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }


    /*
    тут лучше рассматривать наследников от Animal,
    поэтому нужно применить bounded wildcard и заменить обобщение на <? extends Animal>
     */
    public void printBoundedWildCard(List<? extends Animal> list) {
        for (Iterator<? extends Animal> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }


    /*
    тут лучше рассматривать родителей Tiger,
    поэтому нужно применить bounded wildcard и заменить обобщение на <? super Tiger>
     */
    public void printLowerBoundedWildCard(List<? super Tiger> list) {
        for (Iterator<? super Tiger> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}