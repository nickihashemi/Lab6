# Lab6
Algorithm: Have two nodes that iterate through the LL. If the fast node matches (or catches up to) the slow node, you know that the fast node came back around and therefore, it is a circular LL


Runtime: O(n)
- The slower node has to iterate through the LinkedList one by one in order to see if there is a match with the faster node. This means that it has to iterate through n times, making the runtime O(n).

Space Complexity: O(n)
- You need to allocate n number of spaces to have enough space for the n number of elements you add to the LL
