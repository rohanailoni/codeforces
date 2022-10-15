test=int(input())


for _ in range(test):
    arr=list(map(int,input().split(" ")))
    a=arr[0]
    b=arr[1]
    c=arr[2]
    if a==b+c:
        print("Yes")
    elif b==a+c:
        print("Yes")
    elif c==a+b:
        print("YEs")

    else:
        print("NO")
