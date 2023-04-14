# Author: Linyun Liu
# Date: Mar. 16, 2023
# Description: This python program parse a xml result
# Reference: https://www.tutorialspoint.com/biopython/biopython_overview_of_blast.htm
from Bio.Blast import NCBIXML


def print_result():
    for record in NCBIXML.parse(open("result.xml")):
        if record.alignments:
            print("\n")
            print("\33[32m"+"query: %s" % record.query[:100]+"\33[00m")
            for align in record.alignments:
                for hsp in align.hsps:
                    if hsp.expect < 1e-20:
                        print("match: %s " % align.title[:100])


print_result()
