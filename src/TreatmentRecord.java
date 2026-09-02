public class TreatmentRecord {
    int patientId;
    String patientName;
    String treatmentGiven;
    String date;

    public TreatmentRecord(int patientId, String patientName, String treatmentGiven, String date) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentGiven = treatmentGiven;
        this.date = date;
    }

    public String toString() {
        return "PatientID: " + patientId + " | Name: " + patientName +
               " | Treatment: " + treatmentGiven + " | Date: " + date;
    }
}