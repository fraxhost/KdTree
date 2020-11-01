public class Main {

    public static void main(String[] args) {
        /*
        KdTree kdt = new KdTree();
        kdt.checkNodes();
         */

        int[][] points = { {3,6},{17,15},{13,15},{6,12},{9,1},{2,7},{10,19} };

        KdTree kdt = new KdTree();

        int[] point1 = {3,6};
        int[] point2 = {17,15};
        int[] point3 = {13,15};
        int[] point4 = {6,12};
        int[] point5 = {9,1};
        int[] point6 = {2,7};
        int[] point7 = {10,19};

        kdt.add(point1);
        kdt.add(point2);
        kdt.add(point3);
        kdt.add(point4);
        kdt.add(point5);
        kdt.add(point6);
        kdt.add(point7);

        int[] point8 = {1,1};

//        if(kdt.search(point1)) System.out.println("Found point 1");
//        if(kdt.search(point2)) System.out.println("Found point 2");
//        if(kdt.search(point3)) System.out.println("Found point 3");
//        if(kdt.search(point4)) System.out.println("Found point 4");
//        if(kdt.search(point5)) System.out.println("Found point 5");
//        if(kdt.search(point6)) System.out.println("Found point 6");
//        if(kdt.search(point7)) System.out.println("Found point 7");

        System.out.println("In-Order Traversal: ");
        kdt.printInorder(kdt.root);

    }

}
