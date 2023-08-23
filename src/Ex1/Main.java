package Ex1;

public class Main {
    public static void main(String[] args) {
        Student s1= new Student("Andreea",9);
        Student s2= new Student("Alex",8);
        Student s3= new Student("Ion",10);

        Student[] studentArray=new Student[3];
        studentArray[0]=s1;
        studentArray[1]=s2;
        studentArray[2]=s3;

        Student.saveStudents(studentArray);

       studentArray= Student.loadStudents();

        if(studentArray != null){
            System.out.println("Loaded students: ");
            for(Student student:studentArray){
                System.out.println(student);
            }
        }

    }
}