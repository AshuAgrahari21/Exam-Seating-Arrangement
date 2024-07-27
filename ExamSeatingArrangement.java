import java.util.ArrayList;
import java.util.List;



public class ExamSeatingArrangement {
    private List<Student> students;
    private List<Seat> seats;

    public ExamSeatingArrangement() {
        this.students = new ArrayList<>();
        this.seats = new ArrayList<>();
    }

    
    public void addStudent(String name, String rollNumber) {
        Student student = new Student(name, rollNumber);
        students.add(student);
    }

    
    public void assignSeat(String rollNumber, int seatNumber) {
        Student student = getStudentByRollNumber(rollNumber);
        if (student != null) {
            Seat seat = new Seat(seatNumber);
            seats.add(seat);
            student.setSeat(seat);
        }
    }

    
    public void displaySeatingArrangement() {
        System.out.println("Seating Arrangement:");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getRollNumber() + " - Seat " + student.getSeat().getSeatNumber());
        }
    }

  
    private Student getStudentByRollNumber(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    
    private class Student {
        private String name;
        private String rollNumber;
        private Seat seat;

        public Student(String name, String rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
        }

        public String getName() {
            return name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public Seat getSeat() {
            return seat;
        }

        public void setSeat(Seat seat) {
            this.seat = seat;
        }
    }

    
    private class Seat {
        private int seatNumber;

        public Seat(int seatNumber) {
            this.seatNumber = seatNumber;
        }

        public int getSeatNumber() {
            return seatNumber;
        }
    }

    public static void main(String[] args) {
        ExamSeatingArrangement arrangement = new ExamSeatingArrangement();
        arrangement.addStudent("ASHU ", "22BCS11821");
        arrangement.addStudent("CHITRU", "22BCS11827");
        arrangement.assignSeat("22BCS11821", 1);
        arrangement.assignSeat("22BCS11827", 2);
        arrangement.displaySeatingArrangement();
    }
}
