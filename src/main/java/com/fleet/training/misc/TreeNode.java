package com.fleet.training.misc;

import lombok.Data;

//Binary Tree Node
@Data
public class TreeNode
{
    private final int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val)
    {
        this.value = val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right)
    {
        this.value = val;
        this.left = left;
        this.right = right;
    }


}
