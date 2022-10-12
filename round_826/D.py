

ans=0
def recur(arr):
    global ans;
    if(len(arr)==2):
        if(arr[1]>=arr[0]):

            return arr;
        else:
            ans+=1
            arr[1],arr[0]=arr[0],arr[1]
            return arr;

    n=len(arr)
    mid=n//2
    # print(arr[:mid],arr[mid:])
    if(sum(arr[:mid])>sum(arr[mid:])):
        ans+=1
        a=recur(arr[mid:])
        b=recur(arr[:mid])
        return a+b;
    else:
        a=recur(arr[:mid])
        b=recur(arr[mid:])
        return a+b
    
def check(arr)->bool:
    for i in range(0,len(arr),2):
        if(abs(arr[i]-arr[i+1])!=1):
            return False
    return True

def sorted(arr):
    for i in range(1,len(arr)):
        if arr[i]<arr[i-1]:
            return False
    return True

def solve():
    global ans;
    ans=0;
    n=int(input())
    arr=list(map(int,input().split(" ")))
    if(n==1):
        return 0;
    if(check==False):
        return -1
    if(sorted(recur(arr))):
        return ans;
    return -1; 
    




test=int(input())

for _ in range(test):
    ans=solve()
    print(ans)
