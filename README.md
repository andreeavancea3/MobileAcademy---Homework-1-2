# MobileAcademyHomework
Define a Student register. It contains multiple Students, each student having a
name and a grade. Requirements:
• Create a method that saves an array of students into a binary file
• Create a method that loads an array of students from a binary file
• Test the class in a main method
In computing, the producer-consumer problem (also known as the bounded-buffer problem) is a classic example of a multi-process synchronization problem. The problem describes two processes, the producer and the consumer, which share a common, fixed-size buffer used as a queue.
The producer’s job is to generate data, put it into the buffer, and start again.
At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.
Problem
To make sure that the producer won’t try to add data into the buffer if it’s full and that the consumer won’t try to remove data from an empty buffer.

Solution 
The producer is to either go to sleep or discard data if the buffer is full. The next time the consumer removes an item from the buffer, it notifies the producer, who starts to fill the buffer again. In the same way, the consumer can go to sleep if it finds the buffer to be empty. The next time the producer puts data into the buffer, it wakes up the sleeping consumer.
An inadequate solution could result in a deadlock where both processes are waiting to be awakened.

 

Based on the description above, implement a program that will simulate the way Paper Printers are working in a real-life scenario, using Threads concepts:

You have many Producers (let’s say multiple devices that press the Print button on their machine)
You have 1 Consumer (1 printer that has a queue and needs to print those document)
The queue should be limited to 5 documents (let’s call it a hardware limit)
Simulate 3 producers (3 different threads) that are creating tens of documents, 1 by 1 and then sleep for a random amount of time. They should be able to create around 30 documents each.
