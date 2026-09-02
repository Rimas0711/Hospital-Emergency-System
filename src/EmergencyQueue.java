public class EmergencyQueue {
	private static class Node {
		Patient patient;
		Node next;
		Node(Patient p) { this.patient = p; }
	}

	private Node front, rear;

	public void enqueue(Patient p) {
		Node n = new Node(p);
		if (rear == null) { front = rear = n; }
		else { rear.next = n; rear = n; }
		System.out.println("Patient added to queue: " + p.patientId);
	}

	public void dequeue() {
		if (front == null) { System.out.println("No patients in queue."); return; }
		Patient p = front.patient;
		front = front.next;
		if (front == null) rear = null;
		System.out.println("Treating patient: " + p);
	}

	public void display() {
		if (front == null) { System.out.println("Queue is empty."); return; }
		System.out.println("--- Emergency Queue ---");
		Node t = front;
		while (t != null) {
			System.out.println(t.patient);
			t = t.next;
		}
	}
}

