package lab04.exercise6;

public class StudentList {
    private StudentNode head;
    private int size;

    public StudentList() {
        this.head = null;
        this.size = 0;
    }

    // Add to last element
    public void add(Student student) {
        StudentNode newNode = new StudentNode(student);
        
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Remove at specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of range");
            return;
        }

        if (index == 0) {
            head = head.getNext();
        } else {
            StudentNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    // Remove last element
    public void removeLast() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            StudentNode current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
        size--;
    }

    // Clear all elements
    public void clear() {
        head = null;
        size = 0;
    }

    // Display all students
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }

        StudentNode current = head;
        while (current != null) {
            System.out.print(current.getData().getName());
            current = current.getNext();
            if (current != null) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}