package codewars.binary.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SortBinaryTreeByLevels {

    public static List<Integer> treeByLevels(Node node) {
        List<Integer> list = new ArrayList<>();
        List<Node> processed = new ArrayList<>();
        if (node != null) {
            processed.add(node);
            while (!processed.isEmpty()) {
                Node n = processed.get(0);
                list.add(n.value);
                // для обхода в ширину (по уровням, а не по веткам)
                if (n.left != null) processed.add(n.left);
                if (n.right != null) processed.add(n.right);
                processed.remove(0);
            }
        }
        return list;
    }
}