

li=[1,2,3,4,5,6]

for i in range(1,7,2):
    li[i] = li[i]*(-1)
    
print(li)
li.sort()
print(li)
li.reverse()
print(li)

