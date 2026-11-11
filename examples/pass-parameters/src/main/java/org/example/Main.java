package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.entities.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String OUTPUT_DIR = "generated_reports/";
    private static final String REPORTS_STUDENTS_PDF = OUTPUT_DIR + "students-report.pdf";
    private static final String REPORTS_FIRST_REPORT_SIMPLE_BLUE_JRXML = "reports/first-report-simple-blue.jrxml";

    static void main() throws JRException, IOException {
        generateReport(List.of(
                new Student(1L, "Jefté", "Goes", "Salvador", "Bahia"),
                new Student(2L, "Ana", "Silva", "Feira de Santana", "Bahia"),
                new Student(3L, "Carlos", "Santos", "São Paulo", "São Paulo"),
                new Student(4L, "Mariana", "Oliveira", "Rio de Janeiro", "Rio de Janeiro"),
                new Student(5L, "Pedro", "Costa", "Recife", "Pernambuco")
        ));
    }

    public static void generateReport(List<Student> students) throws JRException, IOException {
        Files.createDirectories(Paths.get(OUTPUT_DIR));

        InputStream reportStream = Main.class.getClassLoader().getResourceAsStream(REPORTS_FIRST_REPORT_SIMPLE_BLUE_JRXML);

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("studentName", "Jefté");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, REPORTS_STUDENTS_PDF);
    }
}
