package assgnment;

public class Question5 {
    public static void main(String[] args) {
        String name = "\t\t Deepanshu \t";
        System.out.println("repeat()");
        System.out.println(name.repeat(5));

        System.out.println("\nstrip()");
        System.out.println(name.strip());

        System.out.println("\ntrim()");
        System.out.println(name.trim());

        name = name.strip();

        System.out.println("\nisBlank()");
        System.out.println(name.isBlank());

        System.out.println("\nindent()");
        System.out.println(name.indent(3));

        System.out.println("\ntransform()");
        System.out.print(name.transform((String s) -> "Helo" + s));

        System.out.println("\nstripIndent()");
        System.out.println(name.stripIndent());

        System.out.println("\ntranslateEscapes()");
        System.out.println(name.translateEscapes());

        String tripQuteDemo = """
                Deepans
                huuuuuuuuuuuuu""";

        System.out.println("\ntriple quote demo");
        System.out.println(tripQuteDemo);

        System.out.println("\nformatted()");
        System.out.println("Hello %s!".formatted(name));

    }
}
