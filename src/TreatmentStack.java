import java.util.Stack;

public class TreatmentStack {
    private Stack<TreatmentRecord> stack = new Stack<>();

    // PUSH
    public void push(TreatmentRecord record) {
        stack.push(record);
        System.out.println("Treatment record added for: " + record.patientName);
    }

    // POP
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return null;
        }
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // DISPLAY
    public void display() {
        if (isEmpty()) { System.out.println("No treatment history."); return; }
        System.out.println("--- Treatment History (most recent first) ---");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}