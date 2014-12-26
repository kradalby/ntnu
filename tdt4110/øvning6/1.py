

def counter(n):
    b = 0    
    c = 1
    while b < n:
        a = c**2
        c += 1
        oldb = b
        b += a
        
        if b > n:
           
            return oldb,c
            break

       


a,b = counter(10)

print("Tallet før det vi skrev: ", a)
print("Antall runder: ", b)
