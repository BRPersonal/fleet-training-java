package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.EmptyStackException;
import java.util.Stack;

@Slf4j
public class EvaluationTest2 implements Runnable
{
    public void run()
    {
        String input = "(a{b[ Java Tutorial ]})({}[]))";
        boolean result = validate(input);
        log.debug("input={}, result={}", input,result);
    }

    private boolean validate(String input)
    {
        boolean result = true;
        char[] chars = input.toCharArray();
        int length = chars.length;
        Stack<Character> stack = new Stack<>();

        for(char c : chars)
        {
            if (c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}')
            {
                if (stack.empty())
                {
                    result = false;
                    break;
                }
                else
                {
                    char top = stack.pop();
                    if (((c == ')') && (top != '(')) ||
                            ((c == '}') && (top != '{')) ||
                            ((c == ']') && (top != '[')))
                    {
                        result = false;
                        break;
                    }
                }

            }
        }
        
        return result && stack.empty();

    }
}
