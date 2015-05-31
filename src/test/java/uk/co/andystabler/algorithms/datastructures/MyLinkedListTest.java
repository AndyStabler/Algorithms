package uk.co.andystabler.algorithms.datastructures;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

/**
 * Created by Andy Stabler on 31/05/15.
 */
@RunWith(Enclosed.class)
public class MyLinkedListTest {

    public static class add {

        @Test
        public void oneElement_OneElement() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            Assert.assertEquals(1, list.size(), 0);
        }

        @Test
        public void twoElements_TwoElements() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            Assert.assertEquals(2, list.size(), 0);
        }

        @Test
        public void toEmptyList_Index0() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            Assert.assertEquals(0, list.index("Andy"), 0);
        }

        @Test
        public void toNotEmptyList_Index0() {
            MyList<String> list = new MyLinkedList<>();
            // make list not empty
            list.add("Andy");
            // add to the not empty list
            list.add("Misty");
            Assert.assertEquals(0, list.index("Misty"), 0);
        }

    }

    public static class remove {

        @Test
        public void fromEmpty_False() {
            MyList<String> list = new MyLinkedList<>();
            Assert.assertFalse(list.remove("Andy"));
        }

        @Test
        public void existingFrom1ElementList_True() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            Assert.assertTrue(list.remove("Andy"));
        }

        @Test
        public void existingFrom2ElementList_True() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            Assert.assertTrue(list.remove("Andy"));
        }

        @Test
        public void nonExistingFrom1ElementList_False() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            Assert.assertFalse(list.remove("Misty"));
        }

        @Test
        public void nonExistingFrom2ElementList_False() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            Assert.assertFalse(list.remove("Misty"));
        }

        @Test
        public void atIndex0_removesFirstElement() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.remove(0);
            Assert.assertEquals(1, list.size(), 0);
            Assert.assertEquals(0, list.index("Andy"), 0);
        }

        @Test
        public void atLastIndex_removesLastElement() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.remove(1);
            Assert.assertEquals(1, list.size(), 0);
            Assert.assertEquals(0, list.index("Max"), 0);
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void atNegativeIndex_IndexOutOfBoundsException() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.remove(-1);
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void atIndexGreaterThanListSize_IndexOutOfBoundsException() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.remove(2);
        }
    }

    public static class search {

        @Test
        public void exists_True() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.add("Misty");
            Assert.assertTrue(list.search("Andy"));
        }

        @Test
        public void doesNotExist_False() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.add("Misty");
            Assert.assertFalse(list.search("Alan"));
        }

        @Test
        public void emptyList_False() {
            MyList<String> list = new MyLinkedList<>();
            Assert.assertFalse(list.search("Andy"));
        }
    }

    public static class isEmpty {

        @Test
        public void empty_True() {
            MyList<String> list = new MyLinkedList<>();
            Assert.assertTrue(list.isEmpty());
        }

        @Test
        public void OneElement_False() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            Assert.assertFalse(list.isEmpty());
        }

        @Test
        public void removeOnlyElement_True() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.remove("Andy");
            Assert.assertTrue(list.isEmpty());
        }
    }

    public static class size {

        @Test
        public void emptyList_Zero() {
            MyList<String> list = new MyLinkedList<>();
            Assert.assertEquals(0, list.size(), 0);
        }

        @Test
        public void OneElement_One() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            Assert.assertEquals(1, list.size(), 0);
        }

        @Test
        public void AddOneRemoveOne_Zero() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.remove("Andy");
            Assert.assertEquals(0, list.size(), 0);
        }

        @Test
        public void AddTwoRemoveOne_One() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.remove("Andy");
            Assert.assertEquals(1, list.size(), 0);
        }

        @Test
        public void AddTwoRemoveTwo_Zero() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.remove("Andy");
            list.remove("Max");
            Assert.assertEquals(0, list.size(), 0);
        }
    }

    public static class append {

        @Test
        public void toEmptyList_index0() {
            MyList<String> list = new MyLinkedList<>();
            list.append("Andy");
            Assert.assertEquals(0, list.index("Andy"), 0);
        }

        @Test
        public void toListWithOneElement_index1() {
            MyList<String> list = new MyLinkedList<>();
            // make list not empty
            list.append("Andy");
            // add to the not empty list
            list.append("Misty");
            Assert.assertEquals(1, list.index("Misty"), 0);
        }
    }

    public static class index {

        @Test
        public void first_Zero() {
            MyList<String> list = new MyLinkedList<>();
            list.append("Andy");
            list.append("Misty");
            Assert.assertEquals(0, list.index("Andy"), 0);
        }

        @Test
        public void second_One() {
            MyList<String> list = new MyLinkedList<>();
            list.append("Andy");
            list.append("Misty");
            Assert.assertEquals(1, list.index("Misty"), 0);
        }

        @Test
        public void nonExisting_MinusOne() {
            MyList<String> list = new MyLinkedList<>();
            list.append("Andy");
            list.append("Misty");
            Assert.assertEquals(-1, list.index("Max"), 0);
        }
    }

    public static class insert {

        @Test(expected = IndexOutOfBoundsException.class)
        public void atNegativeIndex_IndexOutOfBoundsException() {
            MyList<String> list = new MyLinkedList<>();
            list.insert(-1, "Andy");
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void atIndexGreaterThanListSize_IndexOutOfBoundsException() {
            MyList<String> list = new MyLinkedList<>();
            list.insert(2, "Andy");
        }

        @Test
        public void atListSize_IndexIsListSize() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");

            list.insert(2, "Misty");
            Assert.assertEquals(2, list.index("Misty"), 0);
        }

        @Test
        public void atIndex0_IndexIs0() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");

            list.insert(0, "Misty");
            Assert.assertEquals(0, list.index("Misty"), 0);
        }

        @Test
        public void atIndex1_IndexIs1() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");

            list.insert(1, "Misty");
            Assert.assertEquals(1, list.index("Misty"), 0);
        }

        @Test
        public void oneElement_sizeInceasesByOne() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");

            list.insert(2, "Misty");
            Assert.assertEquals(3, list.size(), 0);
        }
    }

    public static class pop {

        @Test(expected = NoSuchElementException.class)
        public void emptyList_NoSuchElementException() {
            MyList<String> list = new MyLinkedList<>();
            list.pop();
        }

        @Test
        public void OneElementInList_EmptyList() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.pop();
            Assert.assertTrue(list.isEmpty());
        }

        @Test
        public void TwoElementsInList_OneElementInList() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.pop();
            Assert.assertEquals(1, list.size(), 0);
        }

        @Test
        public void TwoElementsInList_FirstRemoved() {
            MyList<String> list = new MyLinkedList<>();
            list.add("Andy");
            list.add("Max");
            list.pop();
            Assert.assertEquals(0, list.index("Andy"), 0);
        }
    }
}