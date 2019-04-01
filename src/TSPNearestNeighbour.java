
import java.util.InputMismatchException;
import java.util.Stack;

public class TSPNearestNeighbour
{
    private int numberOfNodes;
    private Stack<Integer> stack;

    public TSPNearestNeighbour()
    {
        stack = new Stack<Integer>();
    }
    public int[] tsp(int[][] adjacencyMatrix)
    {
        int[] arr= new int[100];
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new
                int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");

        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if
                        (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {



                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);

                System.out.print(dst +"\t");
                for(int j=0;j<stack.size();j++){
                    arr[j]=stack.get(j);
                }

                minFlag = false;
                continue;
            }


           stack.pop();
        }

        return arr;
    }

    public static int[] main (String[] args) {
        if (args.length < 2) {
            System.out.println("Two arguments required <city> <numbers>");
            System.exit(-1);
        }
        int number_of_nodes;
        number_of_nodes = Integer.parseInt(args[0]);

        String[] splitText = args[1].split(" +");
        int[] mat = new int[splitText.length];
        for (int i = 0; i < splitText.length; i++) {
            mat[i] = Integer.parseInt(splitText[i]);

        }

        int[] abc = new int[100];
        try {
            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            int count = 0;
            for (int i = 1; i <= number_of_nodes; i++) {
                for (int j = 1; j <= number_of_nodes; j++) {
                    if (count == mat.length)
                        break;
                    adjacency_matrix[i][j] = mat[(i - 1) * number_of_nodes + (j - 1)];
                    count++;
                }
            }
            for (int i = 1; i <= number_of_nodes; i++) {
                for (int j = 1; j <= number_of_nodes; j++) {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0) {

                        adjacency_matrix[j][i] = 1;
                    }
                }
            }
            System.out.println("the citys are visited as follows");
            TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
            abc = tspNearestNeighbour.tsp(adjacency_matrix);
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input format");
        }

        return abc;
    }


}