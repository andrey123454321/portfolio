package igra;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Bob", 36);
        Student student2 = new Student("Grek", 21);
        Schoolar schoolar1 = new Schoolar("Biba", 15);
        Schoolar schoolar2 = new Schoolar("Boba", 16);
        Schoolar schoolar3 = new Schoolar("Masha", 11);
        Schoolar schoolar4 = new Schoolar("Sasha", 12);
        Employer employer1 = new Employer("Keks", 48);
        Employer employer2 = new Employer("Chebyrek", 52);
        Team<Student> teamStudent = new Team("Student team");
        Team<Schoolar> teamSchoolar = new Team("Schoolar team");
        Team<Schoolar> teamSchoolar2 = new Team("Schoolar team2");
        Team<Employer> teamEmployer = new Team("Employer team");
        teamStudent.addNewParticipant(student1);
        teamStudent.addNewParticipant(student2);
        teamSchoolar.addNewParticipant(schoolar1);
        teamSchoolar.addNewParticipant(schoolar2);
        teamSchoolar2.addNewParticipant(schoolar3);
        teamSchoolar2.addNewParticipant(schoolar4);
        teamEmployer.addNewParticipant(employer1);
        teamEmployer.addNewParticipant(employer2);
        teamSchoolar.playWith(teamSchoolar2);

    }
}
