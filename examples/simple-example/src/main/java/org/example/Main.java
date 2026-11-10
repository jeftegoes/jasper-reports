package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.entities.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Main {
    static void main() throws JRException, FileNotFoundException {
        generateReport(List.of(
                new Student(1L, "Jefté", "jefte@email.com", "Information Systems", LocalDate.now(), 9.5D),
                new Student(2L, "Ana Silva", "ana@email.com", "Computer Science", LocalDate.now(), 8.5D),
                new Student(3L, "Carlos Santos", "carlos@email.com", "Software Engineering", LocalDate.now(), 7.5D),
                new Student(4L, "Mariana Oliveira", "mariana@email.com", "Information Systems", LocalDate.now(), 9.0D),
                new Student(5L, "Pedro Costa", "pedro@email.com", "Computer Science", LocalDate.now(), 8.0D)
        ));
    }

    public static void generateReport(List<Student> students) throws JRException, FileNotFoundException {
        InputStream reportStream = new FileInputStream(new File("reports/student-report.jrxml"));

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/students.pdf");
    }
}
