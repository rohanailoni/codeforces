test=int(input())
ans=[]

for _ in range(test):
    no_queries=int(input())
    queries=[]
    s="a"
    t="a"
    s_dp=[0 for i in range(26)]
    t_dp=[0 for i in range(26)]
    s_dp[0]+=1
    t_dp[0]+=1
    for quer in range(no_queries):
        a,k,x=input().split(" ")
        k=int(k)
        if int(a)==1:
            s+=int(k)*x
            for i in x:
                s_dp[ord(i)-ord("a")]+=k
        if int(a)==2:
            t+=int(k)*x
            for i in x:
                t_dp[ord(i)-ord("a")]+=k
        s_str=""
        t_str=""
        for i in range(26):
            if s_dp[i]!=0:
                s_str+=chr(i+97)*s_dp[i]
        for i in range(25,-1,-1):
            if t_dp[i]!=0:
                t_str+=chr(i+97)*t_dp[i]

        if s_str>=t_str:
            ans.append("NO")
        elif s_str<t_str:
            ans.append("YES")

        # print("ans_str is equal to :-",ans_str)

for i in ans:
    print(i)



