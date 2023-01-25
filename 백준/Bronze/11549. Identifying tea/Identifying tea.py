t = int(input())
tmp = list(map(int, input().split()))
ans = 0
for i in tmp:
    if i == t:
        ans += 1
print(ans)