import stringlist.StringList;
import stringlist.StringListImpl;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        System.out.println(stringList.add("Petr"));
        System.out.println(stringList.add("Ivan"));
        System.out.println(stringList.get(1));
        System.out.println(stringList.size());
        System.out.println(stringList.indexOf("Petr"));
        System.out.println(stringList.lastIndexOf("Ivan"));
        System.out.println(stringList.contains("Ivan"));
        System.out.println(stringList.remove("Petr"));
        stringList.clear();
        System.out.println(stringList.size());
    }
}
