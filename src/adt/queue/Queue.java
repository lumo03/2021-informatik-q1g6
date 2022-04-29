package adt.queue;

public class Queue {
    private Item first;

    public void enqueue(int data) {
        Item newItem = new Item(data);

        if (isEmpty()) {
            first = newItem;
        } else {
            Item runner = first;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItem);
        }
    }

    public int dequeue() {
        if (first == null) {
            throw new IllegalStateException("Schlange ist leer");
        }

        int data = first.getData();
        first = first.getNext();
        return data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        int count = 0;
        Item runner = first;

        while (runner != null) {
            count++;
            runner = runner.getNext();
        }

        return count;
    }

    // toString => gib die Liste
    // als String aus: 5, 12, 7
    public String toString() {
        String output = "[ ";
        Item runner = first;

        while (runner != null) {
            if (runner != first) {
                output += ", ";
            }

            output += runner.getData();
            runner = runner.getNext();
        }

        return output + " ]";
    }
}

class Item {
    private int data;
    private Item next;

    public Item(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}