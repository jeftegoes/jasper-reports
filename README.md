# Jasper Report Overview and Examples <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. What is reporting and why we need it?](#1-what-is-reporting-and-why-we-need-it)
- [2. What is jasper report?](#2-what-is-jasper-report)
- [3. Bands](#3-bands)
- [4. Parameters, Fields, Variables](#4-parameters-fields-variables)
- [5. Embedding Fonts](#5-embedding-fonts)
- [6. Dependencies](#6-dependencies)

# 1. What is reporting and why we need it?

- Representing Data.
- Having Charts like Bar Chart and Pie Chart.
- **Examples:** Sales Report, Report Card Of Student.

# 2. What is jasper report?

- Its an open source tool to generate reports.
- It offers different formats like PDF, HTML, MS Excel.
- Jasper Studio Community Edition.
- Jasper Reports are having xml format – `jrxml` extention.
- Compiling this JRXML file gives `.jasper` file.
- In Java we use `JasperCompileManager` class to compile Jasper Report.

# 3. Bands

- **Title Band:** Appears just once throughout the report on the very top of the first page.
  - It will not appear on any subsequent pages.
- **Page Header:** Appears at the top of each and every page (except it is typically superseded by the title on the very first page).
  - It repeats on every subsequent page.
- **Column Header, Detail, and Column Footer:** These three work in combination and repeat across pages depending on the volume of data in the **Detail band**.
  - If records span multiple pages, the column headers and footers will repeat accordingly to structure the tabular data.
- **Page Footer:** Appears at the bottom of each and every page (often used for elements like page numbers, e.g., "Page 1 of 2").

# 4. Parameters, Fields, Variables

- Parameter = `$P`
- Field = `$F`
- Variable = `$V`

# 5. Embedding Fonts

- Configure the Font in Jaspersoft Studio
- Instead of relying on system fonts, you must explicitly declare your font files (.ttf) inside the designer tool:
  1. Go to Window > Preferences > Jaspersoft Studio > Fonts.
  2. Click Add to create a new font family.
  3. Enter a Family Name (this is the exact string you will use in your .jrxml files under fontName).
  4. Browse and select the .ttf files for TrueType configurations (Normal, Bold, Italic, and Bold Italic).
  5. Switch to the PDF tab within the same wizard:
     1. Set PDF Encoding to Identity-H (Unicode with horizontal writing).
     2. Check the box for Embed this font in PDF document.

# 6. Dependencies

```xml
    <dependency>
        <groupId>net.sf.jasperreports</groupId>
        <artifactId>jasperreports</artifactId>
        <version>7.1.1</version>
        <scope>compile</scope>
    </dependency>

    <dependency>
        <groupId>net.sf.jasperreports</groupId>
        <artifactId>jasperreports-pdf</artifactId>
        <version>7.1.1</version>
        <scope>compile</scope>
    </dependency>

    <dependency>
        <groupId>net.sf.jasperreports</groupId>
        <artifactId>jasperreports-fonts</artifactId>
        <version>7.1.1</version>
        <scope>compile</scope>
    </dependency>
```
