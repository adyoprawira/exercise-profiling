
###### Adyo Arkan Prawira / 2306173750
# AdPro Tutorial & Assignment

### Module 5

#### JMeter GUI
##### /all-student-name Endpoint

| Listener |  Screenshot |
|--|--|
| View Results Tree | ![Image](https://github.com/user-attachments/assets/2c55a2a2-ea5c-4237-8099-702080d13153) |
| View Results In Table | ![Image](https://github.com/user-attachments/assets/30195aa2-3f7e-46ff-a266-39d51ca1f044)|
| Summary Report | ![Image](https://github.com/user-attachments/assets/02c8df6b-6724-474a-b11e-230b431812a3)|
| Graph Results | ![Image](https://github.com/user-attachments/assets/522b6d0e-2009-49db-b915-844d32b8e902)|

##### /highest-gpa Endpoint

| Listener |  Screenshot |
|--|--|
| View Results Tree | ![Image](https://github.com/user-attachments/assets/de5fb807-8d2a-48f1-a8e0-ff6c3bed6309) |
| View Results In Table |![Image](https://github.com/user-attachments/assets/900dcdd3-d028-4b63-84dd-860e9ce675f0) |
| Summary Report |![Image](https://github.com/user-attachments/assets/56c4146d-26f1-41cd-b9ec-e18170b8cdf9) |
| Graph Results |![Image](https://github.com/user-attachments/assets/9089e672-e52d-4e73-a567-d6593cbc8a26) |

#### Command Line
##### /all-student-name Endpoint
|Command Line| Results |
|--|--|
| ![Image](https://github.com/user-attachments/assets/e5edddb9-7591-4f91-b1f9-1687573428b0) | ![Image](https://github.com/user-attachments/assets/d5c7b53a-aa1b-4887-947d-5e18d5a3a9e6) |

##### /highest-gpa Endpoint
|Command Line| Results |
|--|--|
| ![Image](https://github.com/user-attachments/assets/8278ca3f-9192-4bf6-9d75-8551464a833e) | ![Image](https://github.com/user-attachments/assets/e6ae2c98-af26-4ade-9460-be9465d70304) |

#### Profiling

#### Code Refactored for Optimizations
1. `getAllStudentsWithCourses`

|Before| After |
|--|--|
| ![Image](https://github.com/user-attachments/assets/abdfae63-ab1d-42c9-b80b-3f6cba12f2f5) | ![Image](https://github.com/user-attachments/assets/b309bba5-af15-4647-a956-46883406c45a) |

**Problem:** The original code suffered from the N+1 query problem, making a separate database query for each student to retrieve their courses, leading to significant performance degradation.

**Solution:** The optimized code resolves this by fetching all student courses in a single database query using `findByStudentIdIn` and then efficiently associating them with students using a `Map` for constant-time lookups.

**Result:** Execution Time reduced by around 30%, from 5271ms to 3719ms.

2. `joinStudentNames`

|Before| After |
|--|--|
| ![Image](https://github.com/user-attachments/assets/a8c7c335-b128-4dcd-a6e2-55c691920df0) | ![Image](https://github.com/user-attachments/assets/cabbbeca-7529-4d02-95fb-aecc8538949b) |

**Problem:** The original code performs inefficient string concatenation within a loop and then requires a substring operation to remove the trailing comma and space.

**Solution:** The optimized code leverages Java Streams and `Collectors.joining()` to efficiently concatenate student names with a delimiter, eliminating the need for manual string manipulation and trailing character removal.

**Result** : Execution Time reduced by around 39%, from 382ms to 233ms.

3. `findStudentWithHighestGpa`

|Before| After |
|--|--|
| ![Image](https://github.com/user-attachments/assets/4313f054-f65f-4e44-b8f9-8871dd4565e1) | ![Image](https://github.com/user-attachments/assets/e22a3ffa-cab5-45f4-ac1c-b5261f8f3fa9) |

**Problem:** The original code used a manual loop to iterate through the list of students and track the student with the highest GPA, which can be verbose and less efficient.

**Solution:** The optimized code uses Java Streams and `Comparator.comparingDouble()` to find the student with the maximum GPA in a concise and efficient manner, handling empty lists with `Optional.empty()`.

**Result** :  Execution Time reduced by around 53%, from 136ms to 65ms

#### JMeter Performance Comparison


##### /all-student Endpoint

| Listener |  Before | After |
|--|--|--|
| View Results Tree | ![Image](https://github.com/user-attachments/assets/e31cdbfa-cd30-412b-998d-d23721774b99) |![Image](https://github.com/user-attachments/assets/81472cbe-7af2-4421-b231-5926cf5a40ee)|
| View Results In Table | ![Image](https://github.com/user-attachments/assets/0dec83ae-21b2-4051-a32e-385d97148b55)| ![Image](https://github.com/user-attachments/assets/853dcc28-fc4d-43cf-8ebd-b77d388cea7c)|
| Summary Report | ![Image](https://github.com/user-attachments/assets/675d363a-1645-4cbe-8ed6-77e24bb74b9b)|![Image](https://github.com/user-attachments/assets/d3274401-49b3-4c88-a14c-082601c1a29a)|
| Graph Results | ![Image](https://github.com/user-attachments/assets/d1760b52-7d13-4056-ac21-140c72a5bd2c)|![Image](https://github.com/user-attachments/assets/3ee39b3d-69aa-48c1-bcc4-6a56e745c9ad)|

##### /all-student-name Endpoint

| Listener |  Screenshot | After |
|--|--|--|
| View Results Tree | ![Image](https://github.com/user-attachments/assets/2c55a2a2-ea5c-4237-8099-702080d13153) |![Image](https://github.com/user-attachments/assets/21c007d8-46ec-471b-a112-760898cf700b)|
| View Results In Table | ![Image](https://github.com/user-attachments/assets/30195aa2-3f7e-46ff-a266-39d51ca1f044)| ![Image](https://github.com/user-attachments/assets/bfbc08b6-4d84-447b-9a9c-b1cb49a87183)|![Image](https://github.com/user-attachments/assets/67677211-a255-43c3-8c56-6665f0e47ae0)|
| Summary Report | ![Image](https://github.com/user-attachments/assets/02c8df6b-6724-474a-b11e-230b431812a3)| ![Image](https://github.com/user-attachments/assets/c453a921-74a0-4543-9562-b77c2717ffaa)|
| Graph Results | ![Image](https://github.com/user-attachments/assets/522b6d0e-2009-49db-b915-844d32b8e902)|![Image](https://github.com/user-attachments/assets/661392b0-acdd-4e9a-86e5-7eb0c58ca3ec)|

##### /highest-gpa Endpoint

| Listener |  Screenshot | After |
|--|--|--|
| View Results Tree | ![Image](https://github.com/user-attachments/assets/de5fb807-8d2a-48f1-a8e0-ff6c3bed6309) |![Image](https://github.com/user-attachments/assets/3a4d5c7f-493e-451d-8558-db8ce59fbffc)|
| View Results In Table |![Image](https://github.com/user-attachments/assets/900dcdd3-d028-4b63-84dd-860e9ce675f0) |![Image](https://github.com/user-attachments/assets/661c7efc-17ae-4d7a-b2b9-a8d47410e1e2)|
| Summary Report |![Image](https://github.com/user-attachments/assets/56c4146d-26f1-41cd-b9ec-e18170b8cdf9) |![Image](https://github.com/user-attachments/assets/c6bd3fc0-86c0-478b-8b7e-283a9309b4ff)|
| Graph Results |![Image](https://github.com/user-attachments/assets/9089e672-e52d-4e73-a567-d6593cbc8a26) |![Image](https://github.com/user-attachments/assets/af7630f4-f73a-46d8-90ea-a4ae709cd5cb)|

**Conclusion:** Based on these result comparisons, we have improved the performance of these endpoints. By improving database queries and function complexities, we have significantly reduced the execution time.

### Reflection

> 1. **What is the difference between the approach of performance testing with JMeter and profiling with IntelliJ Profiler in the context of optimizing application performance?**

-   **JMeter:** JMeter simulates user load to measure overall application performance, revealing bottlenecks in terms of response times and throughput under stress. It focuses on the system as a whole.
        
-   **IntelliJ Profiler:** IntelliJ Profiler analyzes the application's runtime behavior, pinpointing specific code segments that cause performance issues, such as CPU-intensive methods or memory leaks. It focuses on the code level.
        

> 2. **How does the profiling process help you in identifying and understanding the weak points in your application?**

-   Profiling shows me exactly where my program is slow or using too much memory.
-   I can see which parts of my code take the longest to run.
-   This helpsme find and fix the specific problems that are making me application perform poorly.

> 3. **Do you think IntelliJ Profiler is effective in assisting you to analyze and identify bottlenecks in your application code?**

Yes, it has helped me identify which exact part/functions in my code which took the longest to run. Which then helps me significantly improve my code by optimizing said part.

> 4. **What are the main challenges you face when conducting performance testing and profiling, and how do you overcome these challenges?**

In my experience, conducting performance testing and profiling can be exhaustive. In order to improve the bottleneck, I have to constantly retest and refactor my code back and forth, which could take a while. Other than that, the profiling feature provided by IntelliJ Profiler is very user friendly.

> 5. **What are the main benefits you gain from using IntelliJ Profiler for profiling your application code?**

I can know which part of my code i should improve since IntelliJ Profiler tells exactly the runtime/execution time of each method calls that is required for each endpoints. This really helps me save effort and time in finding bottlenecks. 

> 6. **How do you handle situations where the results from profiling with IntelliJ Profiler are not entirely consistent with findings from performance testing using JMeter?**

When JMeter and IntelliJ Profiler disagree:

-   Double-check test environments and data are identical.
-   Recognize JMeter shows system issues, Profiler shows code issues.
-   Isolate and replicate the problem scenario in both tools.
-   Consider asynchronous operations and garbage collection.

> 7.  **What strategies do you implement in optimizing application code after analyzing results from performance testing and profiling? How do you ensure the changes you make do not affect the application's functionality?**

-   **Step-by-Step Optimization:** I fix one performance issue at a time, then rigorously measure the result to confirm improvement. Example: Replacing a slow loop, then re-testing.
-   **Automated Testing for Reliability:** I use automated tests before and after changes to guarantee the application still works correctly. Example: Unit tests to ensure data processing remains accurate.
-   **Database Performance Checks:** When moving logic to the database, I analyze query performance to prevent overload. Example: Checking query execution plans after using a complex SQL query.

