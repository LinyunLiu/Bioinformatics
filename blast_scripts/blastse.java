import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class blastsp {
    public static void main(String[] args) throws FileNotFoundException {
        
        String db_dir = "/Users/linyunliu/Desktop/blastpdb";
        String query_path = "/Users/linyunliu/Desktop/saccharomyces_cerevisiae.fasta"; //TODO
        String result_dir = "/Users/linyunliu/Desktop/results/saccharomyces_cerevisiae";
        PrintWriter writer = new PrintWriter("/Users/linyunliu/Desktop/blastse.sh"); //TODO

        File dir = new File(db_dir);
        File[] dirs = dir.listFiles(File::isDirectory);
        assert dirs != null;
        for (File f: dirs){
            System.out.println(f);
        }
        String name;
        for (File f: dirs){
            name = f.getName();
            writer.println("echo "+"'"+"blasting saccharomyces_cerevisiae against "+name+" .........'");
            writer.println("mkdir "+result_dir+"/"+name);
            writer.println("blastp -db "+db_dir+"/"+name+"/"+name+" -query "+query_path+" -outfmt 0 -out "+result_dir+"/"+name+"/result.txt");
            writer.println("\n");
        }
        writer.close();
    }
}