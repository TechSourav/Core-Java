package com.sourav.java.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k
 * 
 * Link : https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 **/



public class SlidingWindow 
{
     
    // A Dequeue (Double ended queue) based method for printing maixmum element of
    // all subarrays of size k
    static void printMax(int arr[],int n, int k)
    {
        // Create a Double Ended Queue, dq that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in dq, i.e., 
        // arr[dq.front[]] to arr[dq.rear()] are sorted in decreasing order
        Deque<Integer> dq = new LinkedList<Integer>();
         
        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from dq
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();   // Remove from rear
             
            // Add new element at rear of queue
            dq.addLast(i);
        }
         
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[dq.peek()] + " ");
             
            // Remove the elements which are out of this window
            while((!dq.isEmpty()) && dq.peek() <= i-k)
                dq.removeFirst();
             
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!dq.isEmpty()) && arr[i] >= arr[dq.peekLast()])
                dq.removeLast();
             
 
            // Add current element at the rear of dq
            dq.addLast(i);
             
        }
         
        // Print the maximum element of last window
        System.out.print(arr[dq.peek()]);
    }
     
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        int arr[]={1,2,3,1,4,5,2,3,6};
        int k=3;
        printMax(arr, arr.length,k);
    }
}