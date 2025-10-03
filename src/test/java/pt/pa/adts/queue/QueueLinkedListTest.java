package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class QueueLinkedListTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    void enqueue() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    void dequeue() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.dequeue();
        assertTrue(queue.isEmpty());
        assertThrows(QueueEmptyException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void front() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.front());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() {
        queue.enqueue(1);
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testFIFO() throws QueueEmptyException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.front());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.front());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}//pina