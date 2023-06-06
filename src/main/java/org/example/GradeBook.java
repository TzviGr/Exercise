package org.example;

public class GradeBook {
    private  Student topStudent;

    public void updateTopStudent(Student student){
        this.topStudent=student;
    }

    public Student getTopStudent() {
        return topStudent;
    }

}
