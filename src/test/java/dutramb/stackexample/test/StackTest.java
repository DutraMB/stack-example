/*
 * The MIT License
 *
 * Copyright 2017 Marcio Branquinho Dutra <mdutra at gmail dot com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dutramb.stackexample.test;

import dutramb.stackexample.Stack;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marcio Branquinho Dutra
 */
public class StackTest {

    private Stack stack;

    @Before
    public void initStack() {
        stack = new Stack();
    }

    @Test
    public void pushOnEmptyStack() {
        stack.push(1);
        assertEquals("stack size", 1, stack.getSize());
        assertEquals("stack peek", new Integer(1), stack.getPeek().getValue());
    }

    @Test
    public void popOnEmptyStack() {
        assertNull("pop in empty stack", stack.pop());
        assertEquals("stack size", 0, stack.getSize());
    }

    @Test
    public void popAfterPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("stack size", 3, stack.getSize());

        assertEquals("popped", new Integer(3), stack.pop().getValue());
        assertEquals("popped", new Integer(2), stack.pop().getValue());
        assertEquals("popped", new Integer(1), stack.pop().getValue());

        assertEquals("stack size after 3 pops", 0, stack.getSize());
    }

    @Test
    public void minValueAfterManyEqualPushes() {
        Integer sameValue = 1;
        stack.push(sameValue);
        stack.push(sameValue);
        stack.push(sameValue);
        assertEquals("min value", sameValue, stack.getMinValue());
    }

    @Test
    public void minValueAfterManyPushes() {
        Integer min = 10;
        stack.push(20);
        stack.push(min);
        stack.push(30);
        assertEquals("min value", min, stack.getMinValue());

        Integer newMin = 5;
        stack.push(newMin);
        assertEquals("new min value", newMin, stack.getMinValue());
    }

    @Test
    public void minValueAfterManyPushesAndPops() {
        Integer min1 = 10;
        Integer min2 = 10;
        stack.push(20);
        stack.push(min1);
        stack.push(30);
        stack.push(min2);
        assertEquals("min value", min2, stack.getMinValue());

        stack.pop();
        stack.pop();
        assertEquals("min value after 2 pops", min1, stack.getMinValue());
    }
}
