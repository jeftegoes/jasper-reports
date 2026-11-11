package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.entities.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String OUTPUT_DIR = "generated_reports/";
    private static final String REPORTS_STUDENTS_PDF = OUTPUT_DIR + "students-report.pdf";
    private static final String REPORTS_FIRST_REPORT_SIMPLE_BLUE_JRXML = "reports/student-report.jrxml";

    static void main() throws JRException, IOException {
        generateReport(List.of(
                new Student(1L, "Jefté", "jefte@email.com", "Information Systems", LocalDate.now(), 9.5D),
                new Student(2L, "Ana Silva", "ana@email.com", "Computer Science", LocalDate.now(), 8.5D),
                new Student(3L, "Carlos Santos", "carlos@email.com", "Software Engineering", LocalDate.now(), 7.5D),
                new Student(4L, "Mariana Oliveira", "mariana@email.com", "Information Systems", LocalDate.now(), 9.0D),
                new Student(5L, "Pedro Costa", "pedro@email.com", "Computer Science", LocalDate.now(), 8.0D)
        ));
    }

    public static void generateReport(List<Student> students) throws JRException, IOException {
        Files.createDirectories(Paths.get(OUTPUT_DIR));

        InputStream reportStream = Main.class.getClassLoader().getResourceAsStream(REPORTS_FIRST_REPORT_SIMPLE_BLUE_JRXML);

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, REPORTS_STUDENTS_PDF);
    }
}
