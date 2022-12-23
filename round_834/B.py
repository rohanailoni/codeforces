test=int(input())
a=[]
for _ in range(test):
    m,sum=list(map(int,input().split(" ")))
    arr=list(map(int,input().split(" ")))
    total=m+len(arr)
    ans=[0 for i in range(total)]
    for i in arr:
        ans[i-1]+=1
    get=0
    got=False
    for i in range(total):
        
        if ans[i]==0:
            get+=i+1
        print(get)
        if get==sum:
            got=True
            break
        if got>sum:
            break
    
    if got:
        a.append("yes")
    else:
        a.append("no")
for i in a:
    print(i)
    