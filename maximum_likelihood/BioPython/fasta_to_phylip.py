from Bio import SeqIO
input_file = "cluster_0_aligned.fasta"
output_file = "cluster_0.phylip"
SeqIO.convert(input_file, "fasta", output_file, "phylip")

