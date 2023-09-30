n = int(input())

c7 = '7' in str(n)

d7 = n % 7 == 0

if c7 and d7:
    print(3)
elif c7:
    print(2)
elif d7:
    print(1)
else:
    print(0)
