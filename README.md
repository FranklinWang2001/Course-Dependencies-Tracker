CS400 Project Four Proposal
===========================

TEAM: IG TEAM FLIPGRID: http://flipgrid.com/cai4375

TA: Mu TA EMAIL: mu.cai@wisc.edu

TEAM EMAILS: 1\. fwang263@wisc.edu 2. pzou4@wisc.edu 3. ezhou22@wisc.edu 4. wcraney@wisc.edu 5. skhirwar@wisc.edu 6. oleffel@wisc.edu

* * * * *

Project Title: Curriculum Planner ("Banvas, or tarp since it's a synonym for Canvas")

Brief Project Description:

<brief project description here: 1) what will the app that you are developing do, and 2) who would use an application like this and why>

1.  The application will provide professors/people who need to design a curriculum the opportunity to plan future classes/courses. Then, using Djikstra's Algorithm, we can search how to design a course/plan out how to teach the course by finding the "easiest" way of doing so (the shortest path). 

2.  People who need to plan out multiple courses will use this (professors, for example). Gives the easiest way of designing a course.

Four Chosen Requirements that this Project Fulfills:

1.  Hash Table - Stores graphs for each course (like one graph for cs 400, one graph for math 340, etc.)

1.  Graph - Dijikstra's shortest path algorithm for each concept in each class

1.  HTML + CSS - for user interface

1.  JavaScript - for added pizzazz to website, interactivity + communication with the backend, loading JSON data from stored information that user will input.

* * * * *

Data Wranglers: Carter Craney

Application Data: 

-   Data loaded by program represents:

-   1.) Courses that are being planned (i.e., CS400, MATH340, etc...)

-   Will be initially inserted as a string, but the data wrangler will transform it into a subject course (see below for data types)

-   2.) Concepts that are taught/introduced in above courses (CS400 contains Graphs, for example)

-   Similar to above, will be inserted as a string. The data wrangler classes process it as a Concept Node, which will contain additional information about the concept as well.

-   Data will be sent through a command-line/JavaFX separate program, Data Wrangler will save that information in a textfile/JSON file for backend to load + frontend to use.

Data Format:

<define the Java type(s) that this data will be store in after it is loaded>

-   Design Subject/Course class

-   Will be a graph that stores the paths between concepts (i.e., addition → subtraction in a math course)

-   Each course can be represented as another node if necessary for more information about the course.

-   Will need to design hashCode for subjects

-   Design Subject Planner Class

-   Will be a hash table that will store the courses for easy access. Almost like a database for multiple subjects.

-   Design ConceptNode

-   Will hold the name of the concept (math, etc...)

-   Will store concept information ("multiplication is...")

* * * * *

Back End Developer: Franklin Wang Sid Khirwar

Data Processing:

-   Put data into graph format

-   Put each separate graph into the hash table

-   Determine weights between concepts inside of courses (difficulty)

-   Delete edges between concepts

-   Delete courses

-   Delete concepts

-   Add courses to Hash Table

-   Add concepts to courses in Graph format

-   Search for courses

-   Search for concepts within courses

-   Check for edges

Front End Interface:

<define the Java interface by listing the specific method signatures that exposes this functionality to the front end of your application>

-   In JavaScript:

-   Have some way of displaying the course

-   Function displayCourse(courseName) {}

-   In Java:

-   Public void addCourse(String courseName)

-   Will create a CourseNode (created by Data Wrangler) with the Course Name

-   Public void addCourseDescription(String courseName)

-   Add to course description of the said courseName. 

-   Public void deleteCourse(String courseName)

-   Will delete the course from the hash table of subjects

-   Public boolean searchCourse(String courseName)

-   Will search the Hash Table of courses to find if the course exists or not.

-   Public void addConcept(String conceptName, String courseName) 

-   Will add the concept name to the specified course as a node in a graph, respectively

-   Public void deleteConcept(String conceptName, String courseName)

-   Will delete the concept from the course name exists

-   Public void addDifficulty(String conceptNameSrc, String conceptNameTarget, String courseName, int weight)

-   Will attach an edge from src to target concepts in the graph with the respective weight (corresponding to difficulty)

-   Public int searchDifficulty(String conceptNameSrc, String conceptNameTarget, String courseName)

-   Will search for edge between the two concepts, return the weight/difficulty.

-   Public void deleteDifficulty(String conceptNameSrc, String conceptNameTarget, String courseName)

-   Will delete the respective edge.

-   Public boolean searchConcept(String conceptName, String courseName)

-   Will search for the concept in the specified course.

-   Any additional Java methods will be added on later if needed.

* * * * *

Front End Developer: Pintao Zou Otto Leffel

User Commands:

-   List all courses

-   Includes searching for courses, adding courses, deleting courses

-   List of all concepts within each course

-   Includes searching for concepts, adding concepts, deleting concepts, adding edges between concepts (edges represent difficulty)

-   Calculate and display the easiest path for teaching a course

-   Text fields for input of info (concepts and courses)

Error Messages:

<brief description of any erroneous input that you anticipate your application gracefully responding to>

-   DuplicateCourse/Concept

-   If adding a duplicated course/concept, will tell user to enter in a new one, respectively

-   Search for Nonexistent course/concept/difficulty

-   Deleting nonexistent course/concept

* * * * *

Test Engineer: Eric Zhou

Test Descriptions:

<list brief (one line) summaries for each of the key tests that you will implement for this application>

-   DuplicateCourse/Concept/Difficulties Test

-   Will check if adding a duplicate course or concept 

-   SearchForNonexistentCourse/Concept/Difficulties Test

-   Will check if searching for valid course/concept/difficulties

-   DeletingNonexistentCourse/Concept/Difficulty Test

-   Will check if deleting valid course/concept/difficulty

-   ValidDifficultyTest

-   Will check if the difficulty is correctly set between a relative range as well as not being negative.

-   SearchEmptySubjects/Courses

-   Will check if searching on empty subject or on an empty course

-   Every previous hash table/graph test

* * * * *

Additional Responsibilities and Notes:

-   <list by role, any additional responsibilities that are expected of team members to help balance the workload for this project... if you are concerned about your project being too simple or too involved, this is also a good place to suggest plans for expanding or contracting your main idea>

-   Two main parts:

-   Frontend application, visualization of the data input to graphs

-   HTML/CSS + CGI? Or JSON.

-   Will load data stored from backend. Backend application will store user input of subjects/classes into a JSON file or text file of some sort which can be accessed by either CGI (loads it via Java, prints it out as valid HTML) or JSON (JavaScript loads the page dynamically using JSON)

-   Will be able to display more information about courses (like a dropdown menu of some sort?)

-   Backend application, for getting user input and using Java data structures

-   Will interact with the data structures + algorithms part of this project (Hash Table + Graphs)

-   Using either command-line/JavaFX, user can input data into data structures. Will store this information into a file of some sorts (JSON/Text File depending on what we choose). Can also load previous text files if necessary to add to already existing curriculums.

-   This project might be very complicated, so we might condense the Backend application to bare minimums + focus on Frontend development due to its complexity.

* * * * *

Schedule:

|

Due 11/24

 |

Data Wranglers

 |

Have ConceptNode + CourseNode relatively finished so we can begin implementation into Hash Table + Graph

 |
|

Back End Developers

 |

Combine Hash Table and Graph into a cohesive backend.

Integrate ConceptNode + CourseNode with backend.

 |
|

Front End Developers

 |

Mockup HTML + CSS template (not CGI)

 |
|

Test Engineers

 |

Write tests for Backend data structures

-   Make sure it doesn't burn down

 |

|

Due 12/01

 |

Data Wranglers

 |

Begin textProcessingClass that will convert into textfile (JSON??) for frontend to use as well as future updates (like reading the text file, loading into subjects, etc...)

 |
|

Back End Developers

 |

Design the backend application (getting user input from front end, using data wrangler classes and sending it to file/JSON, etc...)

 |
|

Front End Developers

 |

Finalize HTML/CSS

Implement JavaScript to show more information about mockup courses

 |
|

Test Engineers

 |

Help Front end develop website + make sure no glaring bugs

 |

|

Due 12/08

 |

Data Wranglers

 |

Make sure that the website functions properly. Work on CGI, JavaScript loading data if we end up using JSON

 |
|

Back End Developers

 |

Make sure that the website functions properly. Work on CGI, JavaScript loading data if we end up using JSON

 |
|

Front End Developers

 |

Make sure that the website functions properly. Work on CGI, JavaScript loading data if we end up using JSON

 |
|

Test Engineers

 |

Make sure that the website functions properly. Work on CGI, JavaScript loading data if we end up using JSON

 |

* * * * *

End of Proposal

Franklin Wang  [11/17/20]                     Carter Craney 11/17/20

Eric Zhou {11/17/20}                             ________________________

Otto Leffel 11/17/20                            ________________________    

Pintao Zou (11/17/20)                         ________________________
