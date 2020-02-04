package school.secondweek;

/**
 * @author: Fuwei Feng
 * @version: 2020/1/24
 */
public class Demo {
    public static<E> Tree<E> mirror(Tree<E> t) {
        if(t.isEmpty()) {
            return new Tree<>();
        } else {
            return new Tree<>(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
        }
    }

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<>(7, new Tree<>(3, new Tree<>(2), new Tree<>(8)), new Tree<>(5));
        System.out.println(t);
        System.out.println(mirror(t));
    }
}
