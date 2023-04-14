import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class build {
    public static void main(String[] args) throws FileNotFoundException {
        
        String file_dir = "/Users/linyunliu/Desktop/proteins"; //TODO
        String db_dir = "/Users/linyunliu/Desktop/blastpdb";
        PrintWriter writer = new PrintWriter("/Users/linyunliu/Desktop/build.sh"); //TODO

        File file = new File(file_dir);
        File[] files = file.listFiles();

        assert files != null;
        String name;
        for (File f: files){
            name = f.getName();
            if (name.contains("fasta")){
                name = name.replace(".fasta","");
                writer.println("echo "+"'"+"building database for "+name+" .........'");
                writer.println("mkdir "+db_dir+"/"+name);
                writer.println("makeblastdb -in "+file_dir+"/"+name+".fasta"+" -parse_seqids -dbtype prot -out "+db_dir+"/"+name+"/"+name);
                writer.println("\n");
            }
        }
        writer.close();
    }
}