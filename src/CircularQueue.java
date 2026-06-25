public class CircularQueue {
    private Request[] data;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        data = new Request[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        // TODO 1: Return true when size equals the array capacity.
        return false;
    }

    public boolean isEmpty() {
        // TODO 2: Return true when the queue has no items.
        return false;
    }

    public boolean enqueue(Request request) {
        // TODO 3: If full, return false.
        // TODO 4: Move rear using modulo arithmetic and insert the request.
        // Formula: rear = (rear + 1) % data.length
        // TODO 5: Increase size and return true.
        return false;
    }

    public Request dequeue() {
        // TODO 6: If empty, return null.
        // TODO 7: Save the front item, clear the old slot, move front using modulo, reduce size and return item.
        return null;
    }

    public Request peek() {
        // TODO 8: Return the front request without removing it.
        return null;
    }

    public int size() {
        return size;
    }

    public int frontIndex() {
        return front;
    }

    public int rearIndex() {
        return rear;
    }
}
