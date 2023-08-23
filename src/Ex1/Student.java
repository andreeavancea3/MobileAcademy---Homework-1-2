package Ex1;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private double grade;
    private static Student[] studentsArray;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public static void saveStudents(Student[] studentsArray){
        try{
        FileOutputStream fileOutputStream=new FileOutputStream("student.data");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentsArray);

        System.out.println("The students have been saved.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Student[] loadStudents(){
        Student[] loadedStudents=null;
        try{
            FileInputStream fileInputStream=new FileInputStream("student.data");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            loadedStudents= (Student[]) objectInputStream.readObject();

            System.out.println("The students have been loaded.");
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return loadedStudents;
    }
    @Override
    public String toString() {
        return "Ex1.Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
