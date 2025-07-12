package com.substring.smartresult.controllers;

import com.substring.smartresult.entities.Mark;
import com.substring.smartresult.entities.Student;
import com.substring.smartresult.payload.StudentForm;
import com.substring.smartresult.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;
    @RequestMapping("/input")
    public String viewResult(){
        System.out.println("Result page");
        return "view_result";
    }
    @RequestMapping("/view")
    public String getResult(){

        return "result_data";
    }

    //showing add result form
    @RequestMapping("/add")
    public String addResult(Model model){
        StudentForm studentForm=new StudentForm();
        model.addAttribute("studentForm",studentForm);
        return "add_result";
    }

    @RequestMapping(value = "/process-form",method = RequestMethod.POST)
    public String saveResult(
            @ModelAttribute StudentForm studentForm,
            Model model
    ){
//        System.out.println(studentForm.getName());
//        System.out.println(studentForm.getRollNumber());
//        System.out.println(studentForm.getEmail());
//        System.out.println(studentForm.getMarks().size());
//        studentForm.getMarks().forEach(marks->{
//            System.out.println("Subject: "+marks.getSubject());
//            System.out.println("Marks="+marks.getMarks());
//            System.out.println("Max marks: "+marks.getMaxMarks());
//            System.out.println("Remarks: "+marks.getRemarks());
//            System.out.println("Grade: "+marks.getGrade());
//            System.out.println("------------------------------------");
//        });
        String studentId=resultService.save(studentForm);
        model.addAttribute("studentId",studentId);

        return "result_success";
    }

//    @RequestMapping(value = "/view-result" ,method = RequestMethod.POST)
    @PostMapping("/view-result")
    public String getResultByRollNumber(
            @RequestParam("rollNumber") String rollNumber,
            Model model
    ){
        System.out.println("roll number:"+rollNumber);
        Student student = resultService.getResultByRollNumber(rollNumber);




        if(student==null){
            return "result_not_found";
        }else {

            double totalMarks=0;
            double totalMaxMarks=0;

            for(Mark mark:student.getMarkList()){
                totalMarks += mark.getMarks();
                totalMaxMarks += mark.getMaxMarks();
            }

            double percentage=(totalMarks/totalMaxMarks)*100;
            model.addAttribute("percentage",String.format("%.2f",percentage));

            model.addAttribute("totalMarks",totalMarks);
            model.addAttribute("totalMaxMarks",totalMaxMarks);

            String totalGrade="F";
            String feedBack="Nice";




            if(percentage>90){
                feedBack="Excellent keep up the good work";
            }else if(percentage>80 && percentage<=90){
                feedBack="Nice , good work ";
            }else if(percentage>70 && percentage<=80){
                feedBack="you can do more but well played";
            }else if(percentage>60 && percentage<=70){
                feedBack="you can do it , work hard";
            }else {
                feedBack="failed but never Give up!!";
            }

            if(percentage>90){
                totalGrade="A+";
            }else if(percentage>80 && percentage<=90){
                totalGrade="A";
            }else if(percentage>70 && percentage<=80){
                totalGrade="B+";
            }else if(percentage>60 && percentage<=70){
                totalGrade="B";
            }else {
                totalGrade="F";
            }



            model.addAttribute("totalGrade",totalGrade);
            model.addAttribute("feedBack",feedBack);
            model.addAttribute("student",student);
            model.addAttribute("marks",student.getMarkList());
            return "result_data";
        }

    }
}
