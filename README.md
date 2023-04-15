==DOCUMENTATIONS FOR BLAST CAMMAND LINE TOOL==

# CONNECT FTP TO DOWNLOAD COMMAND LINE TOOL
ftp://ftp.ncbi.nlm.nih.gov/blast/executables/blast+/LATEST/				
							
# REFERENCES
[1. Blast Software General Introduction](https://blast.ncbi.nlm.nih.gov/doc/blast-help/downloadblastdata.html#blast-executables)
[2. How to blast against a particular set of local sequences (local database)?](https://bioinformaticsreview.com/20190927/how-to-blast-against-a-particular-set-of-local-sequences-local-database/) 
[3. Building a BLAST database with your (local) sequences](https://www.ncbi.nlm.nih.gov/books/NBK569841/)
[4. Blast Command Line Tool User Mannual:](https://www.ncbi.nlm.nih.gov/books/NBK279684/)

# ALIGNMENT FILE OUTPUT OPTIONS (-outfmt x)
| x | Description |
| ----------- | ----------- |
| 0 | pairwise |
| 1 | query-anchored showing identities |
| 2 | query-anchored no identities |
| 3 | flat query-anchored, show identities |
| 4 | flat query-anchored, no identities |
| 5 | XML Blast output |
| 6 | tabular |
| 7 | tabular with comment lines |
| 8 | Text ASN.1 |
| 9 | Binary ASN.1 |
| 10 | Comma-separated values |
| 11 | BLAST archive format (ASN.1) |
| 12 | Seqalign (JSON) |
| 13 | Multiple-file BLAST JSON |
| 14 | Multiple-file BLAST XML2 |
| 15 | Single-file BLAST JSON |
| 16 | Single-file BLAST XML2 |
| 17 | Sequence Alignment/Map (SAM) |
| 18 | Organism Report |

# COMMAND LINE USAGE
### 1. Making BLAST database of local sequences
The input file must consist of sequences in FASTA format.
`$ makeblastdb -in sequence.fasta -parse_seqids -dbtype prot -out /PATH/TO/YOUR/DTATABASE`
Here, -parse_seqids is used because it may later help in parsing the sequence ids of the given sequences for further analyses. -in refers to the input file, -dbtype can be protein or nucleotide and -out is the name of the BLAST database to be created. If your input file is present in another directory then provide the complete path.

### 2. BLAST the local database against a single sequence
`$ blastp -db /PATH/TO/YOUR/DTATABASE -query seq.fasta -outfmt 0 -out result.txt`
`$ blastp -db /PATH/TO/YOUR/DTATABASE -query seq.fasta -outfmt 5 -out result.xml`
where, -db is the BLAST database created in the previous step, -query is a file consisting of FASTA sequence, -outfmt is the output format which can be defined in several ways as shown here, and -numthreads refers to the number of CPUs to be used during the search. In the case of nucleotide sequences, use blastn or any other appropriate blast executable.

### 3. All against all
To BLAST local sequences against the local database created from the same input sequences, the input sequences are used as a query file in FASTA format.
`$ blastp -db blastdb -query sequence.fasta -outfmt 0 -out result.txt`
As you can see in the above command, the database is the same local database created in the first step and the query are the input sequences from which the local database was created in the first place.
