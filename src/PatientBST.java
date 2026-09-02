public class PatientBST {
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) { this.patient = patient; }
    }

    private Node root;

    public void insert(Patient p) {
        root = insertRec(root, p);
        System.out.println("Patient added: " + p.patientId);
    }

    private Node insertRec(Node node, Patient p) {
        if (node == null) return new Node(p);
        if (p.patientId < node.patient.patientId) node.left = insertRec(node.left, p);
        else if (p.patientId > node.patient.patientId) node.right = insertRec(node.right, p);
        else System.out.println("Patient ID already exists.");
        return node;
    }

    public Patient search(int id) {
        Node n = searchRec(root, id);
        return n == null ? null : n.patient;
    }

    private Node searchRec(Node node, int id) {
        if (node == null) return null;
        if (id == node.patient.patientId) return node;
        return id < node.patient.patientId ? searchRec(node.left, id) : searchRec(node.right, id);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node node, int id) {
        if (node == null) { System.out.println("Patient not found."); return null; }
        if (id < node.patient.patientId) node.left = deleteRec(node.left, id);
        else if (id > node.patient.patientId) node.right = deleteRec(node.right, id);
        else {
            // node to be deleted
            if (node.left == null && node.right == null) { System.out.println("Patient deleted: " + id); return null; }
            if (node.left == null) { System.out.println("Patient deleted: " + id); return node.right; }
            if (node.right == null) { System.out.println("Patient deleted: " + id); return node.left; }

            // two children: get inorder successor
            Node succ = minNode(node.right);
            node.patient = succ.patient;
            node.right = deleteRec(node.right, succ.patient.patientId);
            System.out.println("Patient deleted: " + id);
        }
        return node;
    }

    private Node minNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void inOrderDisplay() {
        if (root == null) { System.out.println("No patients in records."); return; }
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.println(node.patient);
        inOrderRec(node.right);
    }
}