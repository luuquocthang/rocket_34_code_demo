import java.util.*;

public class Main {


    <G> void showListIndexGeneric(List<G> arrayList) {
        System.out.println("Show list by index way");
        for (int i = 0; i < arrayList.size(); i++) {
            G temp = arrayList.get(i);
            System.out.println(temp);
        }
    }

    <T> void showSetForeachGeneric(Set<T> list) {
        System.out.println("Show set by foreach way");
        for (T temp : list) {
            System.out.println(temp);
        }
    }

    <T> void showSetIteratorGeneric(Set<T> list) {
        System.out.println("Show set by iterator way");
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T temp = iterator.next();
            System.out.println(temp);
        }
    }

    // cách 1 duyệt theo index
    public static void showListIndex(List<Student> arrayList) {
        System.out.println("Show list by index way");
        for (int i = 0; i < arrayList.size(); i++) {
            Student temp = arrayList.get(i);
//            temp.setMark(temp.getMark()-i);
            System.out.println(temp);
        }
    }

    // cách 2 duyệt kiểu foreach
    public static void showListForeach(List<Student> arrayList) {
        System.out.println("Show list by foreach way");
        for (Student temp : arrayList) {
            System.out.println(temp);
        }
    }

    // cách 2 duyệt kiểu iterator
    public static void showListIterator(List<Student> arrayList) {
        System.out.println("Show list by iterator way");
        Iterator<Student> iStudent = arrayList.iterator();
        while (iStudent.hasNext()) {
            Student temp = iStudent.next();
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "thang5", 10);
        Student s2 = new Student(2, "thang2", 10);
        Student s3 = new Student(3, "thang0", 10);
//        System.out.println(s1);
//        List<Student> studentArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        showListIndex(studentArrayList);
        showListForeach(studentArrayList);
        showListIterator(studentArrayList);

        studentArrayList.add(new Student(4, "thang4", 10) );
        Student s4 = studentArrayList.get(3);
        Student s5 = new Student(5, "thang5", 10);
        studentArrayList.set(1, s5);
        studentArrayList.remove(0);
        studentArrayList.remove(s2);
        studentArrayList.remove(s4);
        showListForeach(studentArrayList);

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(s1);
        studentLinkedList.add(0, s2);
        studentLinkedList.addAll(studentArrayList);
        showListIndex(studentLinkedList);
        showListForeach(studentLinkedList);
        showListIterator(studentLinkedList);

        Stack<Student> studentStack = new Stack<>();
        studentStack.addAll(studentLinkedList);
        showListIndex(studentStack);
        studentStack.pop();
        showListIndex(studentStack);
        studentStack.push(new Student(6, "thang6", 10));
        showListIndex(studentStack);
        Student s7 = studentStack.peek();
        System.out.println("Top of stack" + s7);
        studentStack.remove(0);
        showListIndex(studentStack);

        Vector<Student> studentVector = new Vector<>();
        studentVector.add(s2);
        studentVector.add(s1);
        showListIndex(studentVector);


        Vector<Integer> intVector = new Vector<>();
        intVector.add(3);
        intVector.add(2);
        intVector.add(1);
        intVector.add(1);
        intVector.add(10);
        Main main = new Main();
        main.showListIndexGeneric(intVector);
        main.showListIndexGeneric(studentVector);

        Employee<Integer, Integer> e1 = new Employee<Integer, Integer>(1, "Thang1", 2023);
        Employee<Double, String> e2 = new Employee<Double, String>(1.0, "Thang1", "2023");

        System.out.println(e1);
        System.out.println(e2);
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(e1);
        employeeArrayList.add(e2);


//        Set<Student> studentSet = new HashSet<>();
        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s1);
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        main.showSetForeachGeneric(studentSet);
        main.showSetIteratorGeneric(studentSet);
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(10);
        integerTreeSet.add(1);
        integerTreeSet.add(2);
        integerTreeSet.add(-1);
        main.showSetForeachGeneric(integerTreeSet);
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(s1);
        studentTreeSet.add(s2);
        studentTreeSet.add(s3);
        main.showSetForeachGeneric(studentTreeSet);

        // Sort
        // Cách 1: gọi hàm sort() và implement Comparator
        studentArrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        main.showListIndexGeneric(studentArrayList);

        // Cách 2: implement Comparable trong Class và sử dung Collections.sort() để sort lại list
        ArrayList<Student> studentAlSort = new ArrayList<>();
        studentAlSort.add(new Student(10, "thang10", 10));
        studentAlSort.add(new Student(1, "thang1", 10));
        studentAlSort.add(new Student(5, "thang5", 10));
        studentAlSort.add(new Student(200, "thang200", 10));
        studentAlSort.add(new Student(2, "thang2", 10));
        studentAlSort.add(new Student(3, "thang3", 10));
        Collections.sort(studentAlSort);
        main.showListIndexGeneric(studentAlSort);

        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        studentHashMap.put(1, s1);
        studentHashMap.put(2, s2);
        studentHashMap.put(3, s2);
        studentHashMap.put(null, s3);

        // cách 1 duyệt theo key
        Set<Integer> keys = studentHashMap.keySet();
        //  1.1
        for (Integer k: keys) {
            Student temp = studentHashMap.get(k);
            System.out.println(temp + " with key = " + k );
        }
        // 1.2
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Integer k = iterator.next();
            Student temp = studentHashMap.get(k);
            System.out.println(temp + " with key = " + k );
        }
        // cách 2 duyêt entry interface
        for (Map.Entry<Integer, Student> entry: studentHashMap.entrySet()) {
            Student temp = entry.getValue();
            Integer k = entry.getKey();
            System.out.println(temp + " with key = " + k );
        }
    }
}
