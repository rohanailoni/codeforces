test=int(input())


    
for _ in range(test):
    s=input()
    map={}
    n=len(s);
    for i in range(n):
        if s[i] not in map:
            map[s[i]]=[]
        map[s[i]].append(i+1)

    pre=-1
    curr=0
    visited=[0 for i in range(n)]
    alpha="abcdefghijklmnopqrstuvwxyz"
    ans=0
    rev=[]
    steps=0;
    while True:
        
        if(curr==n-1):
            break;
        if(len(map[s[curr]])!=0):
            while(len(map[s[curr]])!=0):
                
                steps+=1;
                curr=map[s[curr]].pop(0)-1;
                
                rev.append(curr+1)
                
                
            
        else:
            
            max_index=999999;
            del map[s[curr]]
            for i in range(26):
                x=abs((ord(s[curr])-97)-(ord(alpha[i])-97))
                if alpha[i] in map and x<max_index and alpha[i]!=s[curr]:
                    max_index=x
                    max_val=alpha[i]
            
            
            ans+=max_index
            curr=map[max_val][0]-1
            rev.append(curr+1)
            steps+=1
            map[s[curr]].pop(0)
            

    print(str(ans)+" "+str(steps))
    for i in range(len(rev)-1):
        print(rev[i],end=" ")
    print(rev[len(rev)-1])
    #print(rev,ans,steps+1)
           

