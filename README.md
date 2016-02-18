# sort-runtimes
A Webapp using Apache Tomcat running Java to sort a text file with the option of many different sorting algorithms. A simple MySQL query adds the algorithm name, the time it takes to sort, and the number of characters read in from a file in to a table. Some basic HTML in Java Servlet Pages presents the sorted data.  

A project for my Webapps and Data Security class, the idea of comparing the runtimes of various sorting algorithms came to me since I was also taking a course on Algorithms at the same time. 

We often hear about the mathematical definition of an algorithms runtime, generally if it's O(2^n) it's considered slow and if it's O(nlgn) it's considered fast. But how are the speeds in a more relatable context? Can you really make a coffee AND drink it before Bubble sort is done?  (The sort answer is, with enough data, yes, you can...) 

Table from the database query (time is in milliseconds):
```
+----+----------------+-------------+------------+
| id | algorithm_name | time        | char_count |
+----+----------------+-------------+------------+
|  1 | Selection      |  3960.65157 |      50000 |
|  2 | Insertion      |  4337.73991 |      50000 |
|  3 | Merge          |   182.03781 |      50000 |
|  4 | Quick          |   230.02239 |      50000 |
|  5 | Heap           |    36.94819 |      50000 |
|  6 | Radix          |    53.10357 |      50000 |
|  7 | Bubble         | 13260.46015 |      50000 |
+----+----------------+-------------+------------+
```
Enjoy :)
