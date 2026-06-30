import java.util.PriorityQueue;

public class GhanaServiceCentre {
    private CircularQueue normalQueue;
    private CorrectionDeque correctionDeque;
    private PriorityQueue<Request> urgentQueue;
    private ActionStack actions;

    private int overflowCount = 0;
    private int servedCount = 0;
    private int urgentServed = 0;
    private int normalServed = 0;
    private int correctionServed = 0;
    private int totalEstimatedMinutesServed = 0;
    private int urgencyBonus;

    public GhanaServiceCentre(int normalCapacity, int correctionCapacity, int urgencyBonus) {
        this.normalQueue = new CircularQueue(normalCapacity);
        this.correctionDeque = new CorrectionDeque(correctionCapacity);
        this.urgencyBonus = urgencyBonus;
        this.actions = new ActionStack(200);

        this.urgentQueue = new PriorityQueue<>((a, b) -> {
            // Higher priority score should be served first.
            return Integer.compare(computePriority(b), computePriority(a));
        });
    }

    public int computePriority(Request request) {
        
        // Required minimum: urgencyLevel must matter most.
        // Suggested formula:
        // (urgencyLevel * 10) + urgencyBonus - estimatedMinutes + small arrival fairness adjustment
        return (request.urgencyLevel *10)
                + urgencyBonus
                - request.estimatedMinutes
                - request.arrivalOrder;
    }

    public void admitRequest(Request request) {
        // Rule 1: If needsCorrection is true, add to correctionDeque.
        if (request.needsCorrection){
            if (!correctionDeque.isFull()){
                correctionDeque.addRear(request);
                actions.push(new ActionRecord("ADMIT_CORRECTION", request));
            } else {
                overflowCount++;
            }
        }
        // Rule 2: Else if urgencyLevel >= 4, add to urgentQueue.
        else if (request.urgencyLevel >= 4) {
             actions.push(new ActionRecord("ADMIT_URGENT", request));
            urgentQueue.add(request);
        
        }
        // Rule 3: Else add to normalQueue.
        // Rule 4: If any bounded structure is full, increase overflowCount.
        else {
            if (!normalQueue.isFull()) {
                normalQueue.enqueue(request);
                 actions.push(new ActionRecord("ADMIT_NORMAL", request));
            } else {
                overflowCount++;
            }
        }
    }

    public Request serveNextRequest() {
        Request served = null;

        if (!urgentQueue.isEmpty()) {
            served = urgentQueue.poll();
            urgentServed++;

        }
        else if (!correctionDeque.isEmpty()) {
            served = correctionDeque.removeFront();
            correctionServed++;
        }
        else if (!normalQueue.isEmpty()) {
            served = normalQueue.dequeue();
            normalServed++;
        }

        if (served == null) return null;

        servedCount++;
        totalEstimatedMinutesServed += served.estimatedMinutes;
        actions.push(new ActionRecord("SERVE", served));
        return served;
    }

    public void undoLastAction() {
        ActionRecord last = actions.pop();
        if (last == null) return;

        Request r = last.request;

        switch (last.actionType) {

            case "SERVE" -> {
                //Re-insert served request
                admitRequest(r);
                
                //rollback stats (optional but better)
                servedCount--;
                totalEstimatedMinutesServed -= r.estimatedMinutes;
            }
            case "ADMIT_CORRECTION" -> //best effort removal  
                correctionServed--; //optional tracking rollback but not perfect
            case "ADMIT_URGENT", "ADMIT_NORMAL" -> {
            }    
        }
        //PriorityQueue removal is O(n)
        //No direct way to remove from CircularQueue, so we won't attempt it.
            }

    public void printReport() {
        System.out.println("--- FINAL REPORT ---");
        System.out.println("Served total: " + servedCount);
        System.out.println("Urgent served: " + urgentServed);
        System.out.println("Correction served: " + correctionServed);
        System.out.println("Normal served: " + normalServed);
        System.out.println("Overflow count: " + overflowCount);
        System.out.println("Remaining urgent: " + urgentQueue.size());
        System.out.println("Remaining correction: " + correctionDeque.size());
        System.out.println("Remaining normal: " + normalQueue.size());
        double avg = servedCount == 0 ? 0.0 : (double) totalEstimatedMinutesServed / servedCount;
        System.out.printf("Average estimated minutes served: %.2f%n", avg);
    }
}
