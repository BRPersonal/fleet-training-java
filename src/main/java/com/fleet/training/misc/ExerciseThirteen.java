package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseThirteen implements Runnable
{
    @Override
    public void run()
    {
        //input: [1,2,3,4,5,null,8,null,null,6,7,9]
        //output: [4,2,6,5,7,1,3,9,8]
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setRight(new TreeNode(8));
        root.getRight().getRight().setLeft(new TreeNode(9));
        root.getLeft().getRight().setLeft(new TreeNode(6));
        root.getLeft().getRight().setRight(new TreeNode(7));
        inOrder(root);
    }

    private void inOrder(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        inOrder(node.getLeft());
        log.debug("{}",node.getValue());
        inOrder(node.getRight());
    }
}
