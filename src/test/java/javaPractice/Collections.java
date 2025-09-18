package javaPractice;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        List <Integer> arrayList = new ArrayList<>();
        List <Integer>linkedList = new LinkedList();


        arrayList.add(78);
        arrayList.add(28);
        arrayList.add(28);
        arrayList.add(28);
        arrayList.add(28);
        arrayList.add(28);
        arrayList.add(2,97);
        arrayList.addFirst(56);
        arrayList.addLast(98);
        arrayList.addLast(999);
        arrayList.addFirst(56);
        arrayList.addLast(98);
        arrayList.addLast(999);
        arrayList.addLast(96);
        arrayList.addFirst(56);
        arrayList.addLast(98);
        arrayList.addLast(999);
        arrayList.addLast(96);
        arrayList.addLast(96);
        arrayList.addFirst(7);

        linkedList.add(323);
        linkedList.add(431);
        linkedList.add(2,443);
        linkedList.addFirst(512);
        linkedList.addLast(511);
        linkedList.addLast(459);
        linkedList.addLast(963);
        linkedList.addFirst(512);
        linkedList.addLast(511);
        linkedList.addLast(459);
        linkedList.addLast(963);
        linkedList.addFirst(512);
        linkedList.addLast(511);
        linkedList.addLast(459);
        linkedList.addLast(963);
        linkedList.addAll(arrayList);

        System.out.println("Value at index 2: "+arrayList.get(2));
        System.out.println(arrayList.iterator().hasNext());
        System.out.println("List Size of Linked List: "+linkedList.size());
        System.out.println("List Size of Array List: "+arrayList.size());

        System.out.println("***** Printing Linked List *******");
        for (int val: linkedList)
        {
            System.out.print(val+ ",");
        }
        arrayList.remove(4);
        arrayList.removeLast();
        System.out.println("List Size: "+arrayList.size());

        Iterator<Integer> iterator = arrayList.iterator();

        System.out.println("List contents:");

        // Use while loop to navigate through the list
        System.out.println("**** Printing array list via iterator**");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        linkedList.remove(6);
        linkedList.removeLast();

        Iterator <Integer>iterator1 = linkedList.iterator();
        System.out.println("**** Printing linked list via iterator**");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Set <Integer> treeSet = new TreeSet<>();
        Set <Integer> hashSet = new HashSet<>();

        treeSet.add(89);
        treeSet.addAll(linkedList);

        hashSet.add(90);
        hashSet.addAll(arrayList);
        hashSet.addAll(linkedList);

        System.out.println("**** Printing Tree Set *****");
        for (int val: treeSet)
            System.out.print(val+",");

        System.out.println("\n");
        System.out.println("Tree size:"+treeSet.size());

        System.out.println("\n **** Printing Hash Set *****");
        for (int val: hashSet)
            System.out.print(val+",");

    }
}
