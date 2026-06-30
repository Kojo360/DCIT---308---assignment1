import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GhanaServiceSimulator {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java GhanaServiceSimulator <path-to-requests.csv>");
            return;
        }

        // Paramters derived from my index number; 22013774
        int normalCapacity = 9;
        int correctionCapacity = 11;
        int urgencyBonus = 1;
        int serviceSteps = 27;

        GhanaServiceCentre centre = new GhanaServiceCentre(normalCapacity, correctionCapacity, urgencyBonus);
        List<Request> requests = loadRequests(args[0]);

        for (Request r : requests) {
            centre.admitRequest(r);
        }

        System.out.println("--- SERVING REQUESTS ---");
        for (int i = 0; i < serviceSteps; i++) {
            Request served = centre.serveNextRequest();
            if (served == null) {
                System.out.println("No more requests to serve.");
                break;
            }
            System.out.println("Step " + (i + 1) + ": served " + served);

            // Optional test: call undo at one step and explain it in your report.
            // if (i == 4) centre.undoLastAction();
        }

        centre.printReport();
    }

    private static List<Request> loadRequests(String path) throws Exception {
        List<Request> requests = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // header
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    requests.add(Request.fromCsv(line));
                }
            }
        }
        return requests;
    }
}
