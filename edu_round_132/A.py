

test=int(input())
for i in range(test):
    had=int(input())
    doors=list(map(int,input().split(" ")))
    status=[0,0,0]
    for i in range(3):
        status[had-1]=1;
        had=doors[had-1]
        if had==0:
            break
        
    count=0;
    for i in range(3):
        if status[i]==1:
            count+=1;
    if(count==3):
        print("YES")
    else:
        print("NO")
        
        
