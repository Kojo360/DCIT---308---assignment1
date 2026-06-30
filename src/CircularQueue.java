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
        // Queue is full when number of elements equals array capacity.
        return size == data.length;
    }

    public boolean isEmpty() {
        //Queue is empty when number of elements is zero.
        return size == 0;
    }

    public boolean enqueue(Request request) {
        // If full, return false.
        if (isFull()) return false;

        //  Move rear using modulo arithmetic and insert the request.
        // Formula: rear = (rear + 1) % data.length
        rear = (rear + 1) % data.length;
        data[rear] = request;

        //  Increase size and return true.
        size++;
        return true;
    }

    public Request dequeue() {
        // If empty, return null.
        if (isEmpty()) return null;

        //  Save the front item, clear the old slot, move front using modulo, reduce size and return item.
        Request request = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return request;
    }

    public Request peek() {
        //  Return the front request without removing it.
        if (isEmpty()) return null;
        return data[front];
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
