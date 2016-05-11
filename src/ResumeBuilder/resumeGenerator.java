/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResumeBuilder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author krishna keshav
 */
public class resumeGenerator {
    private final Map details; // stores form values from ResumeBuilder.java
    /**
     *
     */
    resumeGenerator(Map detailsFromRB) {
        details = detailsFromRB;
    }
    void createResume() throws IOException {
        Document resume = new Document();
        try {
            
            PdfWriter.getInstance(resume, new FileOutputStream("resume.pdf"));
            resume.open();
 //           resume.add(new Chunk("Name : "));
            resume.add( new Paragraph((String) details.get("Name")) );
 //           resume.add(new Chunk("Email : "));
            resume.add( new Paragraph((String) details.get("Email")) );
            
            resume.add( Chunk.NEWLINE );
            LineSeparator line = new LineSeparator();
            resume.add(line);
            resume.add( Chunk.NEWLINE );
            
            
            resume.close();
            
        } catch(DocumentException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        File file = new File("resume.pdf");
        Desktop.getDesktop().open(file);
        
    }
}
