import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

private Node<Item> headNode;
private Node<Item> tailNode;
private int size;

public Deque(){
        size = 0;
        headNode = null;
        tailNode = null;
}

public boolean isEmpty(){
        return (size == 0);
}

public int size(){
        return size;
}

public void addFirst(Item item){
        if(item == null) throw new java.lang.NullPointerException();
        size++;
        Node newNode = new Node(item);
        //if size is 1 head node is tail node
        if(size == 1) {
                headNode = newNode;
                tailNode = headNode;
        } else {
                newNode.next = headNode;
                headNode.previous = newNode;
                headNode = newNode;
        }
}

public void addLast(Item item){
        if(item == null) throw new java.lang.NullPointerException();
        size++;
        Node newNode = new Node(item);
        if(size == 1) {
                tailNode = newNode;
                headNode = tailNode;
        } else{
                newNode.previous = tailNode;
                tailNode.next = newNode;
                tailNode = newNode;
        }
}

public Item removeFirst(){
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item data = headNode.data;
        headNode = headNode.next;
        //If you're on the last node it's going to point to null
        //and there will be no .previous.
        if(size > 1) headNode.previous = null;
        size--;
        return data;
}

public Item removeLast(){
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item data = tailNode.data;
        tailNode = tailNode.previous;
        if(size > 1) tailNode.next = null;
        size--;
        return data;
}

public Iterator<Item> iterator() {
        return new DequeIterator();
}

class Node<Item>{
Item data;
Node next;
Node previous;
public Node(Item item){
        data = item;
}

}

private class DequeIterator implements Iterator<Item> {

private Node<Item> current = headNode;

public boolean hasNext(){
        return current != null;
}

public void remove(){
        throw new java.lang.UnsupportedOperationException();
}

public Item next(){
        if(!hasNext()) throw new java.util.NoSuchElementException();

        Item data = current.data;
        current = current.next;
        return data;
}

}

public static void main(String[] args){
        Deque<String> myDeque = new Deque<String>();

        String[] test1 = {"001", "002", "003", "004"};
        String[] test2 = {"005", "006", "007", "008"};
        String[] test3 = {"009", "010", "011", "012"};
        String[] test4 = {"013", "014", "015", "016"};

        System.out.println("Adding test1 to head.");
        for(int i = 0; i < test1.length; i++) {
                myDeque.addFirst(test1[i]);
        }

        System.out.println("Popping 1 element from head.");
        System.out.println(myDeque.removeFirst());


        System.out.println("Popping 1 element from tail.");
        System.out.println(myDeque.removeLast());

        System.out.println("Adding test2 to head.");
        for(int i = 0; i < test1.length; i++) {
                myDeque.addFirst(test2[i]);
        }

        System.out.println("Popping all elements from head");
        for(int i = 0; myDeque.size > 0; i++) {
                System.out.println(myDeque.removeFirst());
        }

        System.out.println("Adding test3 to head.");
        for(int i = 0; i < test3.length; i++) {
                myDeque.addFirst(test3[i]);
        }

        System.out.println("Popping 1 element from tail.");
        System.out.println(myDeque.removeLast());
        System.out.println("Popping 1 element from head.");
        System.out.println(myDeque.removeFirst());

        System.out.println("Adding test4 to tail.");
        for(int i = 0; i < test4.length; i++) {
                myDeque.addLast(test4[i]);
        }

        System.out.println("Popping all elements from tail");
        for(int i = 0; myDeque.size > 0; i++) {
                System.out.println(myDeque.removeLast());
        }
}

}
