import java.util.ArrayList;
import java.util.Scanner;

public class KdTree {

    Scanner input;
    private int k;
    private Node root;

    KdTree() {
        input = new Scanner(System.in);
    }

    public void run() {
        System.out.print("Enter K: ");
        k =  input.nextInt();

        System.out.print("1# Add Points\n2# Search\n3# Print\n4# Exit\nEnter Choice: ");
        int option = input.nextInt();

        while (option!=4) {
            if (option==1) {
                System.out.println("Enter point:");
                int[] array = new int[k];
                for (int i=0; i<k; i++) {
                    array[i] = input.nextInt();
                }
                add(array);
            }
            else if (option==2) {
                System.out.println("Enter point: ");
                int[] array = new int[k];
                for (int i=0; i<k; i++) {
                    array[i] = input.nextInt();
                }
                search(array);
            }
            else if (option==3) {
                printDirectory(root, 0, -1);
            }

            System.out.print("1# Add Points\n2# Search\n3# Print\n4# Exit\nEnter Choice: ");
            option = input.nextInt();
        }

    }

    private void add(int[] value) {
        root = addRecursive(root, value, 0);
    }

    private Node addRecursive(Node current, int[] value, int depth) {
        // If current node is null
        if(current == null) {
            return new Node(value);
        }

        int currentDimension = depth % k;

        // If current node is not null
        if(value[currentDimension] < current.value[currentDimension]) {
            current.left = addRecursive(current.left, value, depth+1);
        }
        else {
            current.right = addRecursive(current.right, value, depth+1);
        }

        // This statement will never be used. This is written to avoid syntactical error.
        return current;
    }

    private boolean arePointsSame(int[] values1, int[] values2) {
        for(int i=0; i<k; i++){
            if(values1[i] != values2[i]){
                return false;
            }
        }

        return true;
    }

    private void search(int[] value){
        if (!searchRecursive(root, value, 0)) {
            System.out.println("Point not Found!");
        }
    }

    private boolean searchRecursive(Node current, int[] value, int depth){
        if(current == null) {
            return false;
        }

        if(arePointsSame(current.value, value)) {
            int dimension = (depth%k);

            System.out.print("Point Found");
            System.out.print(", Depth: " + depth);
            System.out.println(", Dimension: " + dimension + ",");
            return true;
        }

        int currentDimension = depth % k;

        if(value[currentDimension] < current.value[currentDimension]) {
            return searchRecursive(current.left, value, depth+1);
        }
        else {
            return searchRecursive(current.right, value, depth+1);
        }
    }

    private void printDirectory(Node node, int depth, int left) {
        if (node == null) return;

        // printing
        String direction = "";
        if(left==1) direction = "l: ";
        else if (left==0) direction = "r: ";
        else direction = "";

        String printNodes = "";
        for (int i=0; i<k; i++) {
            printNodes += node.value[i];
            if(i!=k-1) printNodes += ", ";
        }

        System.out.println(createSpace(depth) + direction + "point[" + printNodes + "]"
                + ", depth: " + depth + ", dimension: " + depth%k);

        printDirectory(node.left, depth+1, 1);

        printDirectory(node.right, depth+1, 0);
    }

    private String createSpace(int depth) {
        String space = "";
        for (int i=0; i<depth; i++) {
            space += " ";
        }
        return space;
    }

}

