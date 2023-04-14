# Author: Linyun Liu
# Date: Mar. 16, 2023
# Description: Run Blast
# Reference: https://www.tutorialspoint.com/biopython/biopython_overview_of_blast.htm

from Bio.Blast import NCBIWWW, NCBIXML
from Bio import SeqIO


def blast_m1():
    sequence_data = open('example.fasta').read()
    print("Blast In Progress......")
    result_handle = NCBIWWW.qblast("blastp", "nr", sequence_data)
    with open('results.xml', 'w') as save_file:
        blast_results = result_handle.read()
        save_file.write(blast_results)


def blast_m2():
    seq_record = next(SeqIO.parse(open('example.fasta'), 'fasta'))
    print("Blast In Progress......")
    result_handle = NCBIWWW.qblast("blastp", "nr", seq_record.seq)
    with open('results.xml', 'w') as save_file:
        blast_results = result_handle.read()
        save_file.write(blast_results)


def print_result():
    for record in NCBIXML.parse(open("result.xml")):
        if record.alignments:
            print("\n")
            print("query: %s" % record.query[:100])
            for align in record.alignments:
                for hsp in align.hsps:
                    if hsp.expect < 1e-20:
                        print("match: %s " % align.title[:100])
