package ru.tinkoff.fintech.homework;

import java.util.Collection;

public class Main {

    public static void main(final String[] args) {

        Object result = null;

        Collection<Integer> myCollection = new MyCollection<>();
        myCollection.add(1996);
        myCollection.add(1997);
        myCollection.add(1998);
        myCollection.add(1998);
        myCollection.add(1999);
        myCollection.add(2000);

        System.out.println("\nbefore: " + myCollection);
//        result  = myCollection.addAll(Arrays.asList(555, 666)); // Добавить несколько элементов. Works
//        result = myCollection.size(); // Works
//        result = myCollection.isEmpty(); // Пуста наша коллекция или нет? Works
//        result = myCollection.add(5); // Добавить один элемент. Works
//        myCollection.clear(); // Ничего не возвращает. Works
//        result = myCollection.contains(1999); // Проверяет, есть ли элемент в нашей коллекции. Works
//        result = myCollection.containsAll(Arrays.asList(1996, 1999)); // Works

result = myCollection.contains(1996);

        System.out.println("result: " + result);

//        Iterator<Integer> iterator = myCollection.iterator();
//        while (iterator.hasNext()) {
//            Integer value = iterator.next();
//            iterator.remove();
//        }
        System.out.println("after: " + myCollection);
    }
}
