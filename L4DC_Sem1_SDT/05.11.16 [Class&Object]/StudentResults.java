public class StudentResults{
  
  String full_name;
  String exam_name;
  String exam_score;
  String exam_grade;
  
  //default constructor
  StringResults(){
  
   full_name = null;
   exam_name = null;
   exam_store = null;
   exam_grade = null;
  }
  
  //parameterized constructor (all fields)
  StringResults(String para_full_name, String para_exam_name, String para_exam_store, String para_exam_grade){
    
    full_name = para_full_name;
    exam_name = para_exam_name;
    exam_store = para_exam_store;
    exam_grade = para_exam_grade;
  }
}

public class ExamDetails{

  public static void main (String[]args){
  
    StudentResults John = new StudentResults();
    System.out.println(John.full_name);
  }
}