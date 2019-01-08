package com.leonenko.epi._15_rec;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import lombok.AllArgsConstructor;

public class _1511_ComputeDiameterOfTree {

    static int diameter(SimpleBinaryTreeNode<?> root) {
        return maxDiameterAndHeight(root).diameter;
    }

    static DiameterAndHeight maxDiameterAndHeight(SimpleBinaryTreeNode<?> root) {
        if (root == null) {
            return new DiameterAndHeight(0, 0);
        }

        var leftDH = maxDiameterAndHeight(root.getLeftChild());
        var rightDH = maxDiameterAndHeight(root.getRightChild());

        var currH = Math.max(leftDH.height, rightDH.height) + 1;
        var currD = Math.max(Math.max(leftDH.diameter, rightDH.diameter),
                leftDH.height + rightDH.height + 1);

        return new DiameterAndHeight(currD, currH);
    }

    @AllArgsConstructor
    private static class DiameterAndHeight {
        private int diameter;
        private int height;
    }
}

