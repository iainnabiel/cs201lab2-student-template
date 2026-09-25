
public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    public void swap(){
        Node<E> current = head;
        Node<E> currentSmallest = head;
        Node<E> currentLargest = head;

        while (current != null) {
            if (current.getElement().compareTo(currentSmallest.getElement()) < 0) {
                currentSmallest = current;
            }
            if (current.getElement().compareTo(currentLargest.getElement()) > 0) {
                currentLargest = current;
            }
            current = current.getNext();
        }

        while (currentLargest.getElement().compareTo(currentSmallest.getElement()) > 0) {

            swapNodes(currentLargest, currentSmallest);

            Node<E> nextSmallest = null;
            Node<E> nextLargest = null;

            current = head;

             while (current != null) {
                if (current.getElement().compareTo(currentSmallest.getElement()) > 0 && (nextSmallest == null || current.getElement().compareTo(nextSmallest.getElement()) < 0)) {
                    nextSmallest = current;
                }
                if (current.getElement().compareTo(currentLargest.getElement()) < 0 && (nextLargest == null || current.getElement().compareTo(nextLargest.getElement()) > 0)) {
                    nextLargest = current;
                }
                current = current.getNext();
            }
            currentLargest = nextLargest;
            currentSmallest = nextSmallest;
        }
    }
   
    public void swapNodes(Node<E> nodeA, Node<E> nodeB) {
        if (nodeA == nodeB) {
            return;
        }

        Node<E> current = head;
        Node<E> prevA = null;
        Node<E> prevB = null;

        while (current != null) {
            if (current.getNext() == nodeA) {
                prevA = current;
            }

            if (current.getNext() == nodeB) {
                prevB = current;
            }

            current = current.getNext();
        }

        if (nodeA.getNext() == nodeB) {

            if (prevA == null) {
                head = nodeB;
            } else {
                prevA.setNext(nodeB);
            }

            nodeA.setNext(nodeB.getNext());
            nodeB.setNext(nodeA);

        } else if (nodeB.getNext() == nodeA) {

            if (prevB == null) {
                head = nodeA;
            } else {
                prevB.setNext(nodeA);
            }

            nodeB.setNext(nodeA.getNext());
            nodeA.setNext(nodeB);

        } else {

            if (prevA == null) {
                head = nodeB;
            } else {
                prevA.setNext(nodeB);
            }

            if (prevB == null) {
                head = nodeA;
            } else {
                prevB.setNext(nodeA);
            }

            Node<E> nextA = nodeA.getNext();

            nodeA.setNext(nodeB.getNext());
            nodeB.setNext(nextA);
        }

        if (tail == nodeA) {
            tail = nodeB;
        } else if (tail == nodeB) {
            tail = nodeA;
        }
        
    }
}

