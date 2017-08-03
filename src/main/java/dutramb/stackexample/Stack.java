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
package dutramb.stackexample;

/**
 *
 * @author Marcio Branquinho Dutra
 */
public class Stack {

    private int size;
    private Element peek;

    public void push(Integer value) {
        Element newElement = new Element(value);
        newElement.setPrevious(this.peek);

        if (!this.isEmpty()) {
            if (newElement.getMin().compareTo(this.peek.getMin()) <= 0) {
                newElement.setMin(newElement.getValue());
            } else {
                newElement.setMin(this.peek.getMin());
            }
        }

        this.peek = newElement;
        this.size++;
    }

    public Element pop() {
        if (isEmpty()) {
            System.out.println("No pop allowed. Stack is empty.");
            return null;
        }
        
        Element removedElement = this.peek;
        if (removedElement != null) {
            this.peek = removedElement.getPrevious();
            this.size--;
        }
        return removedElement;
    }

    public Integer getMinValue() {
        return this.isEmpty() ? null : this.peek.getMin();
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }

        System.out.println("^^ TOP");
        printStack(this.peek);
        System.out.println("__ BOTTOM__Min=" + this.peek.getMin());
    }

    private void printStack(Element e) {
        System.out.println(e);
        if (e.getPrevious() != null) {
            printStack(e.getPrevious());
        }
    }

    public int getSize() {
        return size;
    }

    public Element getPeek() {
        return this.peek;
    }

    public boolean isEmpty() {
        return this.peek == null;
    }

}
