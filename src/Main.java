import java.util.Scanner;

public class Main {
    static PatientBST bst = new PatientBST();
    static EmergencyQueue queue = new EmergencyQueue();
    static TreatmentStack stack = new TreatmentStack();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Hospital Emergency Management System =====");
            System.out.println("1. Add Patient (BST)");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients (In-order)");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Patient (Dequeue)");
            System.out.println("7. Display Queue");
            System.out.println("8. Add Treatment Record (Stack)");
            System.out.println("9. Undo Last Treatment (Pop)");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Visit to Patient History");
            System.out.println("12. Display Patient Visit History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Contact: "); String contact = sc.nextLine();
                    System.out.print("Condition: "); String cond = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, cond));
                }
                case 2 -> {
                    System.out.print("Enter ID to search: "); int id = sc.nextInt();
                    Patient p = bst.search(id);
                    System.out.println(p != null ? p : "Patient not found.");
                }
                case 3 -> {
                    System.out.print("Enter ID to delete: "); int id = sc.nextInt();
                    bst.delete(id);
                }
                case 4 -> bst.inOrderDisplay();
                case 5 -> {
                    System.out.print("Enter Patient ID to add to queue: "); int id = sc.nextInt();
                    Patient p = bst.search(id);
                    if (p != null) queue.enqueue(p); else System.out.println("Patient not found in records.");
                }
                case 6 -> queue.dequeue();
                case 7 -> queue.display();
                case 8 -> {
                    System.out.print("Patient ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Patient Name: "); String name = sc.nextLine();
                    System.out.print("Treatment given: "); String t = sc.nextLine();
                    System.out.print("Date (e.g. 2026-09-02): "); String date = sc.nextLine();
                    stack.push(new TreatmentRecord(id, name, t, date));
                }
                case 9 -> stack.pop();
                case 10 -> stack.display();
                case 11 -> {
                    System.out.print("Enter Patient ID: "); int id = sc.nextInt(); sc.nextLine();
                    Patient p = bst.search(id);
                    if (p == null) { System.out.println("Patient not found."); break; }
                    System.out.print("Visit ID: "); int vid = sc.nextInt(); sc.nextLine();
                    System.out.print("Date: "); String date = sc.nextLine();
                    System.out.print("Doctor: "); String doc = sc.nextLine();
                    System.out.print("Diagnosis: "); String diag = sc.nextLine();
                    System.out.print("Treatment: "); String treat = sc.nextLine();
                    p.visitHistory.addVisit(new Visit(vid, date, doc, diag, treat));
                }
                case 12 -> {
                    System.out.print("Enter Patient ID: "); int id = sc.nextInt();
                    Patient p = bst.search(id);
                    if (p != null) p.visitHistory.display(); else System.out.println("Patient not found.");
                }
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}