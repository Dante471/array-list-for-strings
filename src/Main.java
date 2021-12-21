import stringlist.StringList;
import stringlist.StringListImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        System.out.println(stringList.add("Petr"));
        System.out.println(stringList.getSize());
        System.out.println(stringList.add("Ivan"));
        System.out.println(stringList.getSize());
        System.out.println(stringList.contains("Petr"));
        System.out.println(stringList.remove("Petr"));
        System.out.println(stringList.contains("Petr"));
        System.out.println(stringList.getSize());
        System.out.println(stringList.add("Semen"));
        System.out.println(stringList.indexOf("Semen"));
        System.out.println(stringList.lastIndexOf("Semen"));
        System.out.println(stringList.indexOf("Ivan"));
        System.out.println(stringList.set(1, "Fedor"));
        System.out.println(stringList.contains("Semen"));
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println(stringList.remove(1));
        System.out.println(stringList.contains("Fedor"));
        System.out.println(stringList.getSize());
        System.out.println(stringList.add(0, "Vasilii"));
        System.out.println(Arrays.toString(stringList.toArray()));
        StringList stringList2 = new StringListImpl();
        stringList2.add("Ivan");
        stringList2.add("Semen");
        System.out.println(stringList.equals(stringList2));
        stringList.clear();
        System.out.println(stringList.getSize());

    }
}
