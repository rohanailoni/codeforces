def solve2():
    n=int(input())
    ans=[]
    for i in range(n,0,-1):
        ans.append(i)

    if(n%2==0):
        return " ".join([str(i) for i in ans]);
    if(n==3):
        return -1
    
    else:
        al=n//2
        new=ans[:al]
        for x in ans[al:][::-1]:new .append(x)
        return " ".join([str(i) for i in new])


for _ in range(test):
    ans=solve3()
    

