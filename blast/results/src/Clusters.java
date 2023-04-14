// Author: Linyun Liu
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Clusters {

    public static void main(String[] args) throws FileNotFoundException {
        String file_dir = "/Users/linyunliu/Desktop/Resources/blast/results/schizosaccharomyces_pombe/_results_final";
        File file = new File(file_dir);
        File[] files = file.listFiles(File::isFile);
        assert files != null;

        /* ============= First Steps ==============
        To find the protein sequences that has the most occurrence
        Map: <Sequence ID:String, Occurrence: Integer>
         */
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scan;
        String[] list;
        String key;
        for (File f: files){
            System.out.println("reading file "+f.getName()+"......");
            scan = new Scanner(f);
            scan.nextLine();

            // the file is guaranteed to not exceed 20 lines
            int count = 0;
            while (count < 10) {
                list = scan.nextLine().split(",");
                key = list[0].strip();

                if (map.containsKey(key)) {
                    int tmp = map.get(key);
                    tmp++;
                    map.put(key, tmp);
                } else {
                    map.put(key, 0);
                }
                count++;
            }
        }
        PrintWriter writer = new PrintWriter("./src/tmp/occurrence.csv");
        writer.println("sequences,occurrence");
        Set<String> set = map.keySet();
        for (String k: set){
            writer.println(k+","+map.get(k));
        }
        writer.close();


         /* ============= Second Steps ==============
          * To generate protein clusters, and write it into a file
         */

        // Get the sequence with the highest occurrence
        int min = 8; // TODO the minimum occurrence, subject to change
        scan = new Scanner(new File("./src/tmp/occurrence.csv"));
        scan.nextLine();

        HashMap<String, Integer> targets = new HashMap<>();
        while (scan.hasNext()){
            list = scan.nextLine().split(",");
            if (Integer.parseInt(list[1]) >= min){
                targets.put(list[0],Integer.parseInt(list[1]));
            }
        }
        set = targets.keySet();


        // Write a file indicating the protein clusters with comments
        String name = "schizosaccharomyces_pombe";
        writer = new PrintWriter("./src/clusters/clusters_sp.csv");
        writer.print("cluster No.,");
        writer.print(name);
        for (File f: files){
            writer.print(","+f.getName().replace(".csv",""));
        }
        writer.println();

        int tmp = 0;
        for (String T: set){
            writer.print("cluster "+tmp+","); tmp++;
            writer.print(T);

            for (File f: files){
                scan = new Scanner(f);
                scan.nextLine();

                int count = 0;
                boolean found = false;
                while (count < 20) {
                    list = scan.nextLine().split(",");
                    if (list[0].strip().equals(T)){
                        writer.print(","+list[1].strip());
                        found = true;
                        break;
                    }
                    count++;
                }
                if (!found){
                    writer.print(",N/A");
                }
            }
            writer.println();
        }

        writer.close();





    }
}
