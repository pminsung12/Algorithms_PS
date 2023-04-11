N=int(input())
num_list = list(map(int, input().split()))
num_list.sort()
rst=0
for i in range(0,len(num_list)):
    rst+=(len(num_list)-i)*num_list[i]
print(rst)