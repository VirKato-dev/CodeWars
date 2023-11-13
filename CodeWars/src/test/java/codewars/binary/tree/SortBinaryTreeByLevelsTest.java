package codewars.binary.tree;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortBinaryTreeByLevelsTest {
    @Test
    public void nullTest() {
        assertEquals(Arrays.asList(), SortBinaryTreeByLevels.treeByLevels(null));
    }

    @Test
    public void basicTest() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), SortBinaryTreeByLevels.treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
    }
}