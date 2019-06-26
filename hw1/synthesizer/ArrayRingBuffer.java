
package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    private class IterationHelper implements Iterator<T> {
        private int position = first;
        private int count = 0;
        @Override
        public boolean hasNext() {
            return count < fillCount;
        }
        @Override
        public T next() {
            count += 1;
            T toReturn = rb[position];
            if (position == capacity - 1) {
                position = 0;
            } else {
                position += 1;
            }
            return toReturn;
        }
    }
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {

        if (fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        } else if (last == capacity - 1) {
            rb[last] = x;
            last = 0;
        } else {
            rb[last] = x;
            last += 1;
        }
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {

        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        } else if (first == capacity - 1) {
            T toReturn = rb[first];
            first = 0;
            fillCount -= 1;
            return toReturn;
        } else {
            T toReturn = rb[first];
            first += 1;
            fillCount -= 1;
            return toReturn;
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
            return rb[first];
        }

    }

    public Iterator<T> iterator() {
        return new IterationHelper();
    }
}
