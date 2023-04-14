# Author: Linyun Liu
# Date: Mar. 16, 2023
# Description: To display alignments
# Reference: https://biopython.org/docs/1.76/api/Bio.Align.html

from Bio import pairwise2, SeqIO, Align

seq1 = next(SeqIO.parse(open('example.fasta'), 'fasta'))
seq2 = next(SeqIO.parse(open('example2.fasta'), 'fasta'))
print(f'comparing {seq1.id} and {seq2.id}')


def align_pairwise(sequence1, sequence2):
    # perform pairwise alignment
    alignments = pairwise2.align.globalxx(sequence1.seq, sequence2.seq)
    # print the alignments
    for alignment in alignments:
        print(pairwise2.format_alignment(*alignment))


def align_aligner(sequence1, sequence2):
    # perform pairwise alignment
    aligner = Align.PairwiseAligner()
    alignments = aligner.align(sequence1.seq, sequence2.seq)
    print(alignments[0])
    print("Score = %.1f:" % alignments.score)


def align_local(sequence1, sequence2):
    aligner = Align.PairwiseAligner()
    aligner.mode = "local"
    aligner.match_score = 2
    aligner.mismatch_score = -1
    aligner.open_gap_score = -5
    aligner.extend_gap_score = -1
    alignments = aligner.align(sequence1, sequence2)
    for alignment in sorted(alignments):
        print("Score = %.1f:" % alignment.score)
        print(alignment)


def align_global(sequence1, sequence2):
    aligner = Align.PairwiseAligner()
    aligner.mode = "global"
    aligner.open_gap_score = -0.5
    aligner.extend_gap_score = -0.1
    aligner.target_end_gap_score = 0.0
    aligner.query_end_gap_score = 0.0
    for alignment in aligner.align(sequence1, sequence2):
        print("Score = %.1f:" % alignment.score)
        print(alignment)


align_global(seq1, seq2)
