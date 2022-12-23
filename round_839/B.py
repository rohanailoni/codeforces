test=int(input())



for _ in range(test):
    mat=[]
    for i in range(2):
        a,b=list(map(int,input().split(" ")))
        mat.append([a,b])
    got=False
    if(mat[0][1]>mat[0][0] and mat[1][0]>mat[0][0] and mat[1][1]>mat[1][0] and mat[1][1]>mat[0][1]):
        got=True
    #mat[0][1] is the root
    if(mat[0][0]>mat[0][1] and mat[1][1]>mat[0][1] and mat[1][0]>mat[0][0] and mat[1][0]>mat[1][1]):
        got=True
    #mat[1][1] is the root
    if(mat[0][1]>mat[1][1] and mat[1][0]>mat[1][1] and mat[0][0]>mat[1][0] and mat[0][0]>mat[0][1]):
        got=True
    #mat[1][0] is the root
    if(mat[0][0]>mat[1][0] and mat[1][1]>mat[1][0] and mat[0][1]>mat[0][0] and mat[0][1]>mat[1][1]):
        got=True
    if got:
        print("yes")
    else:
        print("NO")
