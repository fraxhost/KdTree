public class KdTree {

    public static final int k = 2;

    Node root;

    public void add(int[] value) {
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

    public boolean search(int[] value){
        return searchRecursive(root, value, 0);
    }

    private boolean searchRecursive(Node current, int[] value, int depth){
        if(current == null) {
            return false;
        }
        if(arePointsSame(current.value, value)) {
            int dimension = (depth%k);

            System.out.print("-- Depth: " + depth);
            System.out.println(" -- Dimension: " + dimension + ",");
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

    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print("Point: [" + node.value[0] + "," + node.value[1] + "] ");
        search(node.value);

        /* now recur on right child */
        printInorder(node.right);
    }

}

/*
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        // If current node is null
        if(current == null) {
            return new Node(value);
        }

        // If current node is not null
        if(value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private KdTree createKdTree() {
        KdTree kdt = new KdTree();

        kdt.add(6);
        kdt.add(4);
        kdt.add(8);
        kdt.add(3);
        kdt.add(5);
        kdt.add(7);
        kdt.add(9);

        return kdt;
    }

    // Finding an Element
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if(current == null) {
            return false;
        }

        if(value == current.value) {
            return true;
        }
        else if(value < current.value) {
            return containsNodeRecursive(current.left, value);
        }
        else {
            // if(value > current.value)
            return containsNodeRecursive(current.right, value);
        }
    }

    public void checkNodes(){
        KdTree kdt = createKdTree();

        if (kdt.containsNode(6)) System.out.println("6 is present");
        if (kdt.containsNode(4)) System.out.println("4 is present");
        if (kdt.containsNode(1)) System.out.println("1 is present");
    }
*/