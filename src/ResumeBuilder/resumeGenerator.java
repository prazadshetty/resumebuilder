/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResumeBuilder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

/**
 *
 * @author peace
 */
public class resumeGenerator {
    private final Map details; // store form values from ResumeBuilder.java
    /**
     *
     */
    resumeGenerator(Map detailsFromRB) {
        details = detailsFromRB;
    }
    void createResume() {
        Document resume = new Document();
        try {
            
            PdfWriter.getInstance(resume, new FileOutputStream("resume.pdf"));
            resume.open();
            resume.add(new Paragraph((String) details.get("Name")));
            resume.add(new Paragraph((String) details.get("Email")));
            resume.close();
            
        } catch(DocumentException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
}
