public class CorrectionDeque {
    private Request[] data;
    private int front;
    private int rear;
    private int size;

    public CorrectionDeque(int capacity) {
        data = new Request[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
       //Deque is full when number of stored elements equals capacity.
        return size == data.length;
    }

    public boolean isEmpty() {
        //Deque is empty when number of stored elements is zero.
        return size == 0;
    }

    public boolean addRear(Request request) {
        //Adds element to the rear of the deque.
         if (isFull()) return false;

       // Move rear forward circularly
         rear = (rear + 1) % data.length;

         // Insert the request
         data[rear] = request;
         if (size == 0) {
             front = rear; // If the deque was empty, set front to rear
         }
         size++;
         return true;
    }

    public boolean addFront(Request request) {
        //Adds element to the front of the deque.

        if (isFull()) return false;

        // Move front forward circularly
        front = (front - 1 + data.length) % data.length;

        // Insert the request
        data[front] = request;

        //If first element being added, rear should also point to front
        if (size == 0) {
            rear = front; 
        }
        size++;
        return true;
    }

    public Request removeFront() {
    if (isEmpty()) return null;

    Request temp = data[front];
    data[front] = null; //to avoid memory leak

    front = (front + 1) % data.length;

    size--;

    //Reset pointers if deque is empty after removal
    if (size == 0) {
        front = 0;
        rear = -1;
    }
    return temp;
    }   

    public Request removeRear() {
        if (isEmpty()) return null;

        Request temp = data[rear];
        data[rear] = null; 

        // Move rear backward circularly
        rear = (rear - 1 + data.length) % data.length;

        size--;

        //Reset pointers if deque is empty after removal
        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return temp;
    }

    public int size() {
        return size;
    }
}
