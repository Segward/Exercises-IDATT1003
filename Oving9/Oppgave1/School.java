
public class School {

    // en student som har et navn og antall godkjente oppgaver
    public static class Student {
        public String name;
        public int approvedTasks;

        public Student(String name, int approvedTasks) {
            this.name = name;
            this.approvedTasks = approvedTasks;
        }

        public String getName() {
            return name;
        }

        public int getApprovedTasks() {
            return approvedTasks;
        }

        public void approveTask() {
            approvedTasks++;
        }

        public String toString() {
            return String.format("%s, %d", name, approvedTasks);
        }
    }

    // hvor mange studenter som er i klasse og hvor mange godkjente oppgaver hver student har
    public static class TaskManager {
        private Student[] students;
        private int studentCount;

        public TaskManager(Student[] students) {
            this.students = students;
            this.studentCount = students.length;
        }

        public int getStudentCount() {
            return studentCount;
        }

        public int getStudentApprovedTasks(String name) {
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    return student.getApprovedTasks();
                }
            }
            return -1;
        }

        public void registerNewStudent(Student student) {
            Student[] newStudents = new Student[studentCount + 1];
            for (int i = 0; i < studentCount; i++) {
                newStudents[i] = students[i];
            }
            newStudents[studentCount] = student;
            students = newStudents;
            studentCount++;
        }

        public void approveTask(String name) {
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    student.approveTask();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("\nStudent count: %d\n", studentCount));
            for (Student student : students) {
                sb.append(student.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 4),
            new Student("Bob", 3),
            new Student("Charlie", 5)
        };

        TaskManager taskManager = new TaskManager(students);
        System.out.println(taskManager.toString());
        taskManager.registerNewStudent(new Student("David", 2));
        System.out.println(taskManager.toString());
        taskManager.approveTask("David");
        System.out.println(taskManager.toString());
    }
}