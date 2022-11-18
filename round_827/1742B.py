test=int(input())



for _ in range(test):
    n=int(input())
    arr=list(map(int,input().split(" ")))
    if n==1:
        print('yes')
        continue
    arr.sort()
    yay=False
    for i in range(n-1):
        if arr[i+1]==arr[i]:
            print("NO")
            yay=True
            break
    if yay==False:
        print("yes")
        
    
            
