// Author: Linyun Liu
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class BestResults {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        String file_dir = "/Users/linyunliu/Desktop/Resources/blast/results/schizosaccharomyces_pombe";
        File file = new File(file_dir);
        File[] files = file.listFiles(File::isDirectory);

        for (int i = 0; i< Objects.requireNonNull(files).length; i++) {

            System.out.println("Writing "+files[i].getName()+" ......");
            Thread.sleep(500);
            File file_in = new File(files[i].getAbsolutePath()+"/result.csv");
            Scanner scan = new Scanner(file_in);
            HashMap<String, Float> QV = new HashMap<>();
            HashMap<String, String> QS = new HashMap<>();

            // To initialize the variables
            String[] list = scan.nextLine().split(",");
            float score = Float.parseFloat(list[11]);
            String query = list[0];
            String subject = list[1];
            QV.put(query, score);
            QS.put(query, subject);
            System.out.println(0 + " [query:" + list[0] + " subject:" + list[1] + "] [identity:" + list[2] + " evalue:" + list[10] + " score:" + list[11] + "] \u001B[32m✓\u001B[0m");

            float stmp = score;
            String qtmp = query;

            int count = 1;
            while (scan.hasNext()) {
                list = scan.nextLine().split(",");
                score = Float.parseFloat(list[11]); // current score
                query = list[0]; // current query
                subject = list[1]; // current subject

                if (Objects.equals(query, qtmp)) {
                    if (score > stmp) {
                        stmp = score;
                        QV.put(query, score);
                        QS.put(query, subject);
                    }
                } else {
                    QV.put(query, score);
                    QS.put(query, subject);
                    stmp = score;
                    qtmp = query;
                }
                System.out.println(count + " [query:" + list[0] + " subject:" + list[1] + "] [identity:" + list[2] + " evalue:" + list[10] + " score:" + list[11] + "] \u001B[32m✓\u001B[0m");
                count++;
            }
            scan.close();
            writeFile(QV, QS, "/Users/linyunliu/Desktop/_results_final/"+files[i].getName()+".csv");
        }


    }

    public static void writeFile(HashMap<String, Float> QV, HashMap<String, String> QS, String save) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(save);
        writer.println("query,subject,score");

        Set<String> set = QV.keySet();
        for (String key: set){
            writer.print(key+","+QS.get(key)+","+QV.get(key));
            writer.println();
        }

        writer.close();


    }
}