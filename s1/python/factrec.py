def factorial_recursive(n):
	if n== 0:
		return 1
	else:
		return n * factorial_recursive(n-1)
num=int(input("enter a number:"))
result=factorial_recursive(num)
print("factorial of",num, "is",result)
