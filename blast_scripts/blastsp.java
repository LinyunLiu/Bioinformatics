import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class blastsp {
    public static void main(String[] args) throws FileNotFoundException {
        
        String db_dir = "/Users/linyunliu/Desktop/blastpdb";
        String query_path = "/Users/linyunliu/Desktop/schizosaccharomyces_pombe.fasta"; //TODO
        String result_dir = "/Users/linyunliu/Desktop/results/Schizosaccharomyces_pombe";
        PrintWriter writer = new PrintWriter("/Users/linyunliu/Desktop/blastsp.sh"); //TODO

        File dir = new File(db_dir);
        File[] dirs = dir.listFiles(File::isDirectory);
        assert dirs != null;
        for (File f: dirs){
            System.out.println(f);
        }
        String name;
        for (File f: dirs){
            name = f.getName();
            writer.println("echo "+"'"+"blasting schizosaccharomyces_pombe against "+name+" .........'");
            writer.println("mkdir "+result_dir+"/"+name);
            writer.println("blastp -db "+db_dir+"/"+name+"/"+name+" -query "+query_path+" -outfmt 0 -out "+result_dir+"/"+name+"/result.txt");
            writer.println("\n");
        }
        writer.close();
    }
}