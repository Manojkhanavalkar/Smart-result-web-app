package com.substring.smartresult.controllers;

import com.substring.smartresult.payload.StudentForm;
import com.substring.smartresult.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
            @ModelAttribute StudentForm studentForm

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

        return "result_success";
    }
}
