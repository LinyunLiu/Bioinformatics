// Author: Linyun Liu
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SeparateCluster {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        String output_dir = "/Users/linyunliu/Desktop/Resources/blast/clusters/saccharomyces_cerevisiae";

        Scanner scan  = new Scanner(new File("./src/clusters/clusters_sc.csv"));
        String[] names = scan.nextLine().split(",");

        String[] list;
        int count = 0;
        while (scan.hasNext()){
            list = scan.nextLine().split(",");
            System.out.println("\u001B[1;33mGenerating Protein Cluster "+count+"\u001B[0m"); count++;
            //Thread.sleep(2000);
            PrintWriter writer = new PrintWriter(output_dir+"/"+list[0]+".fasta");

            for (int i=1; i<list.length; i++){
                if (!list[i].equals("N/A")) {
                    System.out.println("Finding Sequence "+list[i]+" in "+names[i]);
                    writer.println(getSequence("./src/proteins_all/"+names[i]+".fasta", list[i])+ "\n\n");
                }
                //TODO IMPORTANT
            }
            System.out.println("\n\n");
            writer.close();
        }
    }

    private static String getSequence(String file_name, String ID) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file_name.strip()));
        String line;
        String output = "";
        while (scan.hasNext()){
            line = scan.nextLine();
            if (line.contains(ID.strip())){
                System.out.println("Found \u001B[32m✓\u001B[0m");
                output = output.concat(line+"\n"); //print the header
                while (true) {
                    line = scan.nextLine();
                    if (!line.contains(">")){
                        output = output.concat(line+"\n");
                    }
                    else{
                        break;
                    }
                }

                break;
            }
        }
        return output;
    }
}
