package pt.pa.adts.queue;

import javax.lang.model.element.Element;
import java.util.List;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        this.header = new ListNode(null,null,null);
        this.trailer = new ListNode(null,null,null);
        this.size = 0;

        header.next = trailer;
        trailer.prev = header;
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException {
        if (elem == null){
            throw  new NullNotAllowedException();
        }
        ListNode lastNode = trailer.prev;
        ListNode temp = new ListNode(elem, lastNode, trailer);


        lastNode.next = temp;
        trailer.prev = temp;

        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if(isEmpty()) throw new QueueEmptyException();
        size--;

        ListNode temp = header.next;
        T ele = temp.element;

        ListNode nextTemp = temp.next;

        header.next = nextTemp;
        nextTemp.prev = header;

        temp.next = null;
        temp.prev = null;
        temp.element = null;

        return ele;
    }

    @Override
    public T front() throws QueueEmptyException {
        if(size <= 0) return null;
        else return header.next.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;

    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }}
}