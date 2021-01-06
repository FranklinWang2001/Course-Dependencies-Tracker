// --== CS400 File Header Information ==--
// Name: Franklin Wang
// Email: fwang263@wisc.edu
// Team: IG
// TA: Mu Cai
// Lecturer: Florian Heimerl
// Notes to Grader: none

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Class representing all majors with all courses needed for completion of each
 * major.
 */
public class Backend {
    // TODO: change back to private before submitting
    // Made public for testing purposes
    public HashTableMap<String, MajorGraph<CourseNode>> table;

    /**
     * Creates a Backend instance so that app can function.
     */
    public Backend() {
        // Each major is represented by a string, each HashNode contains a Graph
        // representing a major
        table = new HashTableMap<String, MajorGraph<CourseNode>>();
    }

    /**
     * Adds a new major sequence to the table of majors.
     * 
     * @param majorName - the major specified by user
     * @return true if major is successfully added, false if major already exists
     */
    public boolean addMajor(String majorName) {
        return table.put(majorName, new MajorGraph<CourseNode>());
    }

    /**
     * Deletes a major sequence from the table of majors.
     * 
     * @param majorName - the major specified by user
     * @return the major sequence that is removed from the table
     */
    public MajorGraph<CourseNode> deleteMajor(String majorName) {
        return table.remove(majorName);
    }

    /**
     * Checks whether a given major sequence exists in the table.
     * 
     * @param majorName - the major specified by user
     * @return true if major exists in table, false if major does not exist in table
     */
    public boolean checkMajor(String majorName) {
        return table.containsKey(majorName);
    }

    /**
     * Adds a new course to specified major sequence.
     * 
     * @param majorName  - the major specified by user
     * @param courseCode - the course number specified by the user (eg: 400 for
     *                   CS400)
     * @param courseName - the name of the course specified by the user(eg:
     *                   Programming III for CS400)
     * @return true if course is successfully added, false otherwise
     */
    public boolean addCourse(String majorName, String courseName) {
        CourseNode newCourse = new CourseNode(courseName);
        return table.get(majorName).insertVertex(newCourse);
    }

    /**
     * Removes a specified course from a specified major sequence.
     * 
     * @param majorName - the major specified by user
     * @param course    - the course specified by the user
     * @return true if course is successfully removed, false if course did not exist
     *         before
     */
    public boolean removeCourse(String majorName, String courseName) {
        CourseNode nodeToRemove = new CourseNode(courseName);
        return table.get(majorName).removeVertex(nodeToRemove);
    }

    /**
     * Checks whether a specified course exists in a major sequence.
     * 
     * @param majorName - the major specified by user
     * @param course    - the course specified by the user
     * @return true if course exists in major sequence, false otherwise
     */
    public boolean searchCourse(String majorName, String courseName) {
        CourseNode nodeToSearch = new CourseNode(courseName);
        return table.get(majorName).containsVertex(nodeToSearch);
    }

    /**
     * Adds a connection between two courses in a specified major sequence.
     * 
     * @param majorName - the major specified by user
     * @param preReq    - the requisite course for the target course specified
     * @param depCourse - the course that depends on the prerequisite course
     * @param credits   - the number of credits of the prequisite course
     * @return true if connection was successfully added, false if connection
     *         already existed
     */
    public boolean addCourseConnection(String majorName, String preReq, String depCourse, int credits) {
        CourseNode preReqNode = new CourseNode(preReq);
        CourseNode depCourseNode = new CourseNode(depCourse);
        return table.get(majorName).insertEdge(preReqNode, depCourseNode, credits);
    }

    /**
     * Removes a course connection between two courses in a specified major
     * sequence.
     * 
     * @param majorName - the major specified by user
     * @param preReq    - the requisite course for the target course specified
     * @param depCourse - the course that depends on the prerequisite course
     * @return true if connection was successfully removed, false if connection was
     *         not found
     */
    public boolean removeCourseConnection(String majorName, String preReq, String depCourse) {
        CourseNode preReqNode = new CourseNode(preReq);
        CourseNode depCourseNode = new CourseNode(depCourse);

        return table.get(majorName).removeEdge(preReqNode, depCourseNode)
                && table.get(majorName).removeEdge(depCourseNode, preReqNode);
    }

    /**
     * Finds all course dependencies for a given class using Prim's MST algorithm.
     * 
     * @param majorName - the major specified by user
     * @param course    - the course to find dependencies for
     */
    public String findCourseDependencies(String majorName, String course) {
        CourseNode courseToFind = new CourseNode(course);
        LinkedList<CourseNode> minSpanningTree = table.get(majorName).primsSpanningTree(courseToFind)
                .depthFirstSearch(courseToFind);

        String message = "Original Course: " + minSpanningTree.peek().getName() + "\n";
        message += "Prequisites: ";

        Iterator<CourseNode> mstIterator = minSpanningTree.iterator();
        
        if (minSpanningTree.size() == 1) {
            message += " None";
            return message;
        }

        while (mstIterator.hasNext()) {
            String nextCourse = mstIterator.next().getName();
            if (!mstIterator.hasNext()) {
                message += nextCourse;
                break;
            }
            if (!message.contains(nextCourse)) {
                message += nextCourse + ", ";
            }
        }

        return message;
    }

}