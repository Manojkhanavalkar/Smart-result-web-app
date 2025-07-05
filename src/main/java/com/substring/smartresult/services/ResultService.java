package com.substring.smartresult.services;

import com.substring.smartresult.entities.Mark;
import com.substring.smartresult.entities.Student;
import com.substring.smartresult.payload.StudentForm;
import com.substring.smartresult.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResultService {
    @Autowired
    private StudentRepo studentRepo;
    public String  save(StudentForm studentForm){
        Student student=new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName(studentForm.getName());
        student.setRollNumber(studentForm.getRollNumber());
        student.setDob(studentForm.getDob());
        student.setEmail(studentForm.getEmail());
        student.setGender(studentForm.getGender());
        student.setSchoolName(studentForm.getSchoolName());

        List<Mark> marksList = studentForm.getMarks().stream().map(markForm -> {
            Mark marks = new Mark();
            marks.setSubject(markForm.getSubject());
            marks.setMarks(markForm.getMarks());
            marks.setMaxMarks(markForm.getMaxMarks());
            marks.setRemark(markForm.getRemarks());
            marks.setGrade(markForm.getGrade());
            return marks;
        }).toList();

        student.setMarkList(marksList);
        Student savedStudent=studentRepo.save(student);
        System.out.println("Student saved with id:"+savedStudent.getId());
        return savedStudent.getId();

    }
}
