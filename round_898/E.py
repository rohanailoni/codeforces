testcase=int(input())
def getval(cache,num):
    ans=0;
    for i in arr:
        if num>i:
            ans=ans+(num-i)

        
    return ans

def solve(n,x,arr):
    maxHeight=max(arr);
    power=1000000000
    # cache=[0 for i in range(power+1)];
    
    # for i in arr:
    #     cache[i]+=1
    # print(cache)
    i=1
    j=power+1
    possans=1
    while i<=j:
        mid=(i+j)//2
        mod=getval(arr,mid)
        if mod==x:
            return mid
        if mod>x:
            j=mid-1;
        else:
            possans=mid;
            i=mid+1

    return possans;






ans=[]
for _ in range(testcase):
    n,x=list(map(int,input().split(" ")));
    arr=list(map(int,input().split(" ")));
    ans.append(solve(n,x,arr));

for i in ans:
    print(i)