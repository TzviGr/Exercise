package org.example;

public class Main {
    public static void main(String[] args) {
       final ShareResource<Student> shareResource=new ShareResource<>();
       final GradeBook gradeBook=new GradeBook();
       Thread threadA =new Thread(()->{
           while (true){
               shareResource.addToList(new Student());
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });
        Thread threadB =new Thread(()->{
            while (true){
                Student student=shareResource.removeFromList();
                if (student!=null){
                    System.out.println("Processed" +student);
                    if (gradeBook.getTopStudent()==student){
                        gradeBook.updateTopStudent(null);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadC =new Thread(()->{
            while (true) {
               Student student=new Student();
               Student bast=shareResource.getList().get(0);
               int max=0;
                for (int i = 0; i <student.getCoursesGrades().values().size() ; i++) {
                    max += student.getCoursesGrades().values();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}