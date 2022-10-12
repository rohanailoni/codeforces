def solve():  
   
    a,b=list(map(str,input().split(" ")))
    dic={'M':2,"S":1,"L":3}
    if a=="M":
        if b=="M":
            return "="
        if b[-1]=="S":
            return ">"
        if b[-1]=="L":
            return "<"
    if b=="M":
        if a[-1]=="S":
            return "<"
        if a[-1]=="L":
            return ">"
    if(a[-1]=="S" and b[-1]=="S"):
        if(len(a)>len(b)):
            return "<"
        if len(b)>len(a):
            return ">"
        if len(a)==len(b):
            return "="
    if(a[-1]=="L" and b[-1]=="L"):
        if(len(a)>len(b)):
            return ">"
        if len(b)>len(a):
            return "<"
        if len(a)==len(b):
            return "="
    if(a[-1]=="L" and b[-1]=="S"):
        return ">"
    if(a[-1]=="S" and b[-1]=="L"):
        return "<"
