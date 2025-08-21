class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        //build the adj List - with graph
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, recStack)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean hasCycle(
        List<List<Integer>> graph,
        int course,
        boolean[] visited,
        boolean[] recStack
    ) {
        visited[course] = true;
        recStack[course] = true;

        for(int nextCourse : graph.get(course)) {
            if(!visited[nextCourse]) {
                if(hasCycle(graph, nextCourse, visited, recStack)) {
                    return true;
                }
                //if this is already in the path
            } else if(recStack[nextCourse]){
                return true;
            }
          }

          //we are done exploring this course. so backtrack
          recStack[course] = false;
        return false; 
    }   
}
