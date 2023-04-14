==SOFTWARE DOCUMENTAION==

#INTRODUCTION
Clustal Omega is a multiple sequence alignment program developed by the Computational Biology Research Group at University College Dublin. It is the successor to the widely used ClustalW program and is a powerful tool for aligning three or more biological sequences, such as DNA or protein sequences. Clustal Omega uses a sophisticated algorithm to produce high-quality alignments quickly and accurately.
One of the key advantages of Clustal Omega over other alignment programs is its ability to handle large datasets quickly and efficiently. It uses a scalable parallel algorithm that can take advantage of multi-core processors and distributed computing environments. Additionally, Clustal Omega can handle a wide variety of sequence types, including nucleotide and protein sequences, as well as RNA and DNA sequences with complex structures.

# REASON OF USING
In order to generate ML phylogenetic tree using other software (using cluster.fasta file), the fasta file need to be formatted
The original cluster.fasta file contais protein sequences that have different length and they are not aligned
Hence, the **clustalo** software is capable of formatting the cluster.fasta file 
- align the sequences
- using "-" to fill the sequence gap

# USAGE
`./clustalo -i "input.fasta" -o output.fasta --auto -v`

# ALIGNMENT FASTA VISUALIZATION
[SMS](https://www.bioinformatics.org/sms2/color_align_prop.html)
[JALVIEW](https://www.jalview.org/)
[NCBI](https://www.ncbi.nlm.nih.gov/projects/msaviewer/)