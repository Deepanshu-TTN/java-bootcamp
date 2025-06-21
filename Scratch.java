/** <i>What would happen if a function is overloaded with 3 different classes and null is passed to it?</i><br>
 Compiler wont resolve as null can represent emptyness of all the objects<br><br>
<i>How to fix?</i><br>
Extend the overloaded passed classes and java now looks for ''the most specific method'' i.e. the 'most' child
*/
public class Scratch {
    Scratch() {
        System.out.print("Hi");
    }

    class A{}
    class b extends A{}
    class C extends b{}

    void display(A name) {
        System.out.println(" " + name);
    }
    void display(b name) {
        System.out.println(" " + name);
    }
    void display(C name) {
        System.out.println(" " + name);
    }
    public static void main(String[] args) {
        Scratch s = new Scratch();
        s.display(null);
    }
}

