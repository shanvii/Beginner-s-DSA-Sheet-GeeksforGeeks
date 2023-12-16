https://www.geeksforgeeks.org/problems/find-nk-th-node-in-linked-list/1?page=1&sprint=ca8ae412173dbd8346c26a0295d098fd&sortBy=submissions

<h1> Find n/k th node in Linked list </h1>

Given a singly linked list and a number k. Write a function to find the (N/k)th element, where N is the number of elements in the list. We need to consider ceil value in case of decimals.

## Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case consists of an integer N. The second line consists of N spaced integers.The last line consists of an integer k.

## Output:
Print the data value of (N/k)th node in the Linked List.

## User Task:
The task is to complete the function fractional_node() which should find the n/kth node in the linked list and return its data value.

## Constraints: 
1 <= T <= 100  <br>
1 <= N <= 100  <br>
K > 0  <br>

## Example:
**Input:**  <br>
2  <br>
6  <br>
1 2 3 4 5 6  <br>
2  <br>
5  <br>
2 7 9 3 5  <br>
3  <br>

**Output:**  <br>
3  <br>
7  <br>

## Explanation:
**Testcase 1:** 6/2th element is the 3rd(1-based indexing) element which is 3.  <br>
**Testcase 2:** 5/3rd element is the 2nd element as mentioned in question that we need to consider ceil value in case of decimals. So 2nd element is 7.
