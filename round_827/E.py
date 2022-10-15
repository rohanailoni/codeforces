test=int(input())

def min_search(prefix,min_arr,k):
    ans=-1
    left=0
    right=len(prefix)
    while(left<right):
        mid=left+(right-left)//2
        if min_arr[mid]==k:
            ans=mid;
            left=mid+1
        elif min_arr[mid]>k:
            right=mid;
        elif min_arr[mid]<k:
            ans=mid
            left=mid+1
    return ans;

for _ in range(test):
    n,m=list(map(int,input().split(" ")))
    arr=list(map(int,input().split(" ")))
    que=list(map(int,input().split(" ")))
    prefix=[arr[0]]
    for i in range(1,n):
        prefix.append(prefix[-1]+arr[i])
    min_arr=[arr[0]]
    for i in range(1,n):
        min_arr.append(max(arr[i],min_arr[i-1]))
    
    # print(prefix,min_arr)
    ans=[]
    for i in range(m):
        x=min_search(prefix,min_arr,que[i])
        
        if x!=-1:
            ans.append(prefix[x])
        else:
            ans.append(0)

    print(" ".join([str(a) for a in ans]))

