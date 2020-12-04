import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Graph test case writer.
 */
class GraphWriter {

    /**
     * Gets input and writes graph test cases.
     *
     * @param args Default parameter.
     * @throws IOException If there are errors writing file.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename:");
        String fileName = scanner.nextLine();
        System.out.println("Enter number of nodes & edges:");
        new GraphWriter().writeTestCase(fileName, scanner.nextInt(), scanner.nextInt());
    }

    /**
     * Writes graph test cases.
     *
     * @param fileName      File name to write test case to.
     * @param numberOfNodes Number of nodes.
     * @param numberOfEdges NUmber of edges.
     * @throws IOException If error writing test cases.
     */
    private void writeTestCase(String fileName, int numberOfNodes, int numberOfEdges) throws IOException {
        BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> nodes = new ArrayList<>(numberOfNodes);

        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(i);
        }

        for (int i = 0; i < numberOfEdges; i++) {
            Collections.shuffle(nodes);
            stringBuilder.append(nodes.get(0)).append("\t").append(nodes.get(1)).append("\n");
            stringBuilder.append(nodes.get(1)).append("\t").append(nodes.get(0)).append("\n");
        }

        myWriter.write(stringBuilder.toString());

        myWriter.close();
    }
}
