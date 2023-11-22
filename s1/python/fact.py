def factorial_loop(n):
	factorial=1
	for i in range(1,n+1):
		factorial *= i
	return factorial
num=int(input("enter a number:"))
result=factorial_loop(num)
print("factorial of",num, "is",result)


