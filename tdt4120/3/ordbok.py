from sys import stdin, stderr
import traceback

class Node:
    def __init__(self):
        self.child = {}
        self.posi = []

def build(wordlist):
    topnode = Node()
    for word in wordlist:
        node = topnode
        for letter in word[0]:
            if letter not in node.child:
                node.child[letter] = Node()
            node = node.child[letter]
        node.posi.append(word[1])
    return topnode

def position(word, index, node):
    if index == len(word):
        return node.posi
    elif word[index] == '?':
        #pos = []
        #for l in node.child:
        #    pos += position(word,index + 1, node.child[l])
        #pos = [position(word,index + 1, node.child[l]) for l in node.child]
        #pos = [item for sublist in pos for item in sublist]
        pos = [item for sublist in (position(word,index + 1, node.child[l]) for l in node.child) for item in sublist]
        return pos
    elif word[index] not in node.child:
        return []
    else:
        return  position(word,index + 1, node.child[word[index]])
try:
    word = stdin.readline().split()
    wordlist = []
    pos = 0
    for o in word:
        wordlist.append( (o,pos) )
        pos += len(o) + 1
    topnode = build(wordlist)
    for searchword in stdin:
        searchword = searchword.strip()
        print searchword + ":",
        posi = position(searchword, 0, topnode)
        posi.sort()
        for p in posi:
            print p,
        print
except:
    traceback.print_exc(file=stderr)
