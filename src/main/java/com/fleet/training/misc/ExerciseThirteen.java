package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExerciseThirteen implements Runnable
{
    private static final int NULL_NODE = -1;

    @Override
    public void run()
    {
        int[] input = {1,2,3,4,5,NULL_NODE,8,NULL_NODE,NULL_NODE,6,7,9};
        TreeNode root = createTree(input);
        inOrder(root);
    }

    private TreeNode createTree(int[] inputs)
    {
        if ((inputs == null) || (inputs.length == 0) )
        {
            throw new RuntimeException("Invalid inputs. Array is empty");
        }

        TreeNode rootNode = new TreeNode(inputs[0]);
        List<TreeNode> queue = new ArrayList<>();
        List<TreeNode> pruningList = new ArrayList<>();
        queue.add(rootNode);

        for(int i = 1; i < inputs.length; i++)
        {
            int currVal = inputs[i];
            if (queue.isEmpty())
            {
                throw new RuntimeException("Invalid inputs. Array contains Junk data");
            }

            TreeNode newNode = new TreeNode(currVal);
            TreeNode firstNode = queue.getFirst();
            if (firstNode.getLeft() == null)
            {
                firstNode.setLeft(newNode);
            }
            else if (firstNode.getRight() == null)
            {
                firstNode.setRight(newNode);
                queue.removeFirst();
            }

            if (currVal == NULL_NODE)
            {
                pruningList.add(firstNode);
            }
            else
            {
                queue.add(newNode);
            }

        }

        //remove Null nodes
        for(TreeNode node : pruningList)
        {
            if (node.getLeft() != null && node.getLeft().getValue() == NULL_NODE)
            {
                node.setLeft(null);
            }
            else if (node.getRight() != null && node.getRight().getValue() == NULL_NODE)
            {
                node.setRight(null);
            }
        }

        return rootNode;
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
