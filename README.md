# 1. Parameters, Fields, Variables

- Parameter = `$P`
- Field = `$F`
- Variable = `$V`

# 2. Embedding Fonts

- Configure the Font in Jaspersoft Studio
- Instead of relying on system fonts, you must explicitly declare your font files (.ttf) inside the designer tool:
  1. Go to Window > Preferences > Jaspersoft Studio > Fonts.
  2. Click Add to create a new font family.
  3. Enter a Family Name (this is the exact string you will use in your .jrxml files under fontName).
  4. Browse and select the .ttf files for TrueType configurations (Normal, Bold, Italic, and Bold Italic).
  5. Switch to the PDF tab within the same wizard:
     1. Set PDF Encoding to Identity-H (Unicode with horizontal writing).
     2. Check the box for Embed this font in PDF document.

# 3. Dependencies

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
