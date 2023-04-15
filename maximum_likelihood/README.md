SOFTWARE DOCUMENTAION

# INTRODUCTION
PhyML-3.1 is a software that generate ML phylogenetic tree and all its related data
> "New Algorithms and Methods to Estimate Maximum-Likelihood Phylogenies: Assessing the Performance of PhyML 3.0."
Guindon S., Dufayard J.F., Lefort V., Anisimova M., Hordijk W., Gascuel O.
Systematic Biology, 59(3):307-21, 2010.

# USAGE
`./phyml -i cluster.phylip -d aa -m LG -b 100`  

Here's a brief explanation of each option: (might not all supported)
1. -i or --input: The name of the input file (in multi-fasta format).
2. -d or --datatype: The data type (NT for nucleotide, AA for amino acid).
3. -m or --model: The substitution model to use.
4. -f or --frequencies: The base frequencies (Empirical, F3x4, or F1x4).
5. -u or --use_length: Use sequence length correction (Y/N).
6. -o or --output: The name of the output file.
7. -c or --classes: The number of gamma rate classes.
8. -a or --alpha: The alpha parameter for the gamma distribution.
9. -v or --invfreq: Use empirical or estimated base frequencies (Y/N).
10. -b or --bootstrap: The number of bootstrap replicates.
11. -s or --seed: The seed for the random number generator.
12. -t or --tree: The starting tree (BIONJ, UPGMA, random, user).
13. -k or --nbest: The number of best trees kept.
14. -e or --epsilon: The stopping criterion (likelihood increase).
15. -p or --pinv: The proportion of invariable sites.
16. -g or --nloops: The number of nearest neighbor interchanges (NNIs) per branch.
17. -h or --help: Display the help message.
18. -z or --interleaved: Specify whether the input file is interleaved (Y/N).
19. -y or --no_memory_check: Turn off memory checks.

`./phyml -i cluster.phylip -d aa -m LG -b 100 -o n` 

1. -o n: no parameter is optimised.
2. -o r: substitution rate parameters are optimised.
3. -o l: branch lengths are optimised.
4. -o lr: branch lengths and substitution rate parameters are optimised.
5. -o tl: tree topology and branch lengths are optimised.
6. -o tlr: tree topology (t), branch length (l) and substitution rate parameters (r) are optimised.  

*more usage information in PhyML-3.1_manual.pdf*

# **IMPORTANT !**
*the out put contains .txt file in newick format which can be used to plot the tree using `Bio.Phylo`*

*the input file 'cluser.phylip' is a converted fomart from cluster.fasta, this new format is required
for the software to read and genertae a newwick file*

# PYTHON SCRIPTS
## to convert fasta to phylip
```python
from Bio import SeqIO
input_file = "cluster_10_aligned.fasta"
output_file = "cluster.phylip"
SeqIO.convert(input_file, "fasta", output_file, "phylip")
```


## to generate ML phylogenetic tree (example)
```python
from Bio import Phylo
import matplotlib.pyplot as plt

tree = Phylo.read("tree.txt", "newick")

plt.figure(figsize=(50, 50))
Phylo.draw(tree, do_show=False)

plt.gca().spines['top'].set_visible(True)
plt.gca().spines['bottom'].set_visible(True)
plt.gca().spines['left'].set_visible(True)
plt.gca().spines['right'].set_visible(True)

plt.gca().spines['top'].set_linestyle('-')
plt.gca().spines['bottom'].set_linestyle('-')
plt.gca().spines['left'].set_linestyle('-')
plt.gca().spines['right'].set_linestyle('-')

plt.gca().spines['top'].set_color('red')
plt.gca().spines['bottom'].set_color('red')
plt.gca().spines['left'].set_color('red')
plt.gca().spines['right'].set_color('red')

plt.title('Phylogenetic Tree Using ML')

plt.savefig('tree.png', dpi=1000)
```











