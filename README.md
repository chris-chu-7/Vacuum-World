# Vacuum World

This project was created in order to answer problem set 2 for Artificial Intelligence: A Modern Approach Chapter 2 -Intelligent Agents. It implements a vacuum world reflex agent.

![alt text](https://www.cs.nmsu.edu/~rth/cs/cs475/images/vacuum2-environment-1.jpg)

The following image shows a vacuum agent in just 2 states, states A and B. This program allows the user to define the state (floor) size. If one square of the "floor" environment has dirt on it, the vacuum will suck. Else, it moves to another consecutive square where again it checks the condition-action rules to determine how to proceed. The program terminates when all the states are empty. This Algorithm has a worst case time complexity of O(n) More information can be found in the agent.java file. 
