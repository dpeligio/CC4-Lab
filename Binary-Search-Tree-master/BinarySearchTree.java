import java.util.Random;

public class BinarySearchTree {
    public static void main(String[] args) {
        Node root = null;
        Tree bst = new Tree();
        final int SIZE = 2000000;
        int[] a = new int[SIZE];

        System.out.printf("Generating random array with %d values...%n", SIZE);

        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            a[i] = random.nextInt(10000);
        }

        long end = System.nanoTime();

        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
        System.out.printf("Filling the tree with %d nodes...%n", SIZE);

        start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            root = bst.insert(root, a[i]);
        }

        end = System.nanoTime();

        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
        System.out.printf("Traversing all %d nodes in tree...%n", SIZE);

        start = System.nanoTime();

        bst.traverse(root);

        end = System.nanoTime();

        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
    }
}