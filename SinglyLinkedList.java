import java.util.ArrayList;
import java.util.List;

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
    public void swap() {
    
    List<Node<E>> nodes = new ArrayList<>();
    Node<E> current = head;
    while (current != null) {
        nodes.add(current);
        current = current.getNext();
    }

    List<Node<E>> byValue = new ArrayList<>(nodes);
    byValue.sort((a, b) -> a.getElement().compareTo(b.getElement()));

    int low = 0;
    int hi = byValue.size() - 1;

    while (low < hi) {
        Node<E> smallestNode = byValue.get(low);
        Node<E> largestNode = byValue.get(hi);

        if (smallestNode.getElement().compareTo(largestNode.getElement()) >= 0) {
            break;
        }

        swapNodes(largestNode, smallestNode);
        low++;
        hi--;
    }
}
   
        public void swapNodes(Node<E> nodeA, Node<E> nodeB) {
            if (nodeA == nodeB) {
                return;
            }
            
            E temp = nodeA.getElement();
            nodeA.element = nodeB.getElement();
            nodeB.element = temp;
        }

}

