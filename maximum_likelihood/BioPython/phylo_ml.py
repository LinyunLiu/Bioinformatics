from Bio import Phylo
import matplotlib.pyplot as plt

tree = Phylo.read("tree_sc.txt", "newick")

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

plt.gca().spines['top'].set_linewidth(2)
plt.gca().spines['bottom'].set_linewidth(2)
plt.gca().spines['left'].set_linewidth(2)
plt.gca().spines['right'].set_linewidth(2)

plt.title('Phylogenetic Tree Using ML (saccharomyces_cerevisiae)', fontdict={'fontsize': 14, 'fontweight': 'bold', 'fontfamily': 'Times New Roman'})
plt.savefig('tree_sc.png', dpi=1000)
