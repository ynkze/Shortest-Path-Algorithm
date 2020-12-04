import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Hospital test case writer.
 */
class HospitalWriter {

    /**
     * Gets input and writes hospital test cases.
     *
     * @param args Default parameter.
     * @throws IOException If there are errors writing file.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename:");
        String fileName = scanner.nextLine();
        System.out.println("Enter number of nodes & hospitals:");
        new HospitalWriter().writeTestCase(fileName, scanner.nextInt(), scanner.nextInt());
    }

    /**
     * Writes hospital test cases.
     *
     * @param fileName         File name to write test case to.
     * @param numberOfNodes    Number of nodes.
     * @param numberOfHospital NUmber of hospitals.
     * @throws IOException If error writing test cases.
     */
    private void writeTestCase(String fileName, int numberOfNodes, int numberOfHospital) throws IOException {
        BufferedWriter myWriter = new BufferedWriter(new FileWriter(fileName));
        StringBuilder stringBuilder = new StringBuilder("# " + numberOfHospital + "\n");
        ArrayList<Integer> nodes = new ArrayList<>(numberOfNodes);

        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(i);
        }

        Collections.shuffle(nodes);

        for (int i = 0; i < numberOfHospital; i++) {
            stringBuilder.append(nodes.get(i)).append("\n");
        }

        myWriter.write(stringBuilder.toString());

        myWriter.close();
    }
}
