public class Scratch implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        Scratch og = new Scratch();
        Scratch clone = og.clone();
    }

    public Scratch clone() throws CloneNotSupportedException {
        Scratch scratch = (Scratch) super.clone();
        return scratch;
    }
}