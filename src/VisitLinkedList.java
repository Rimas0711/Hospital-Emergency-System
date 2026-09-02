public class VisitLinkedList {
    private Visit head;

    // ADD
    public void addVisit(Visit v) {
        if (head == null) {
            head = v;
        } else {
            Visit temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = v;
        }
        System.out.println("Visit added: " + v.visitId);
    }

    // REMOVE
    public void removeVisit(int visitId) {
        if (head == null) { System.out.println("No visits to remove."); return; }
        if (head.visitId == visitId) { head = head.next; return; }
        Visit temp = head;
        while (temp.next != null && temp.next.visitId != visitId) temp = temp.next;
        if (temp.next == null) { System.out.println("Visit not found."); return; }
        temp.next = temp.next.next;
        System.out.println("Visit removed: " + visitId);
    }

    // SEARCH
    public Visit search(int visitId) {
        Visit temp = head;
        while (temp != null) {
            if (temp.visitId == visitId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // DISPLAY
    public void display() {
        if (head == null) { System.out.println("No visit history."); return; }
        Visit temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}