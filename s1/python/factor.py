def find_factors(numbers):
	factors= []
	for i in range(1, number + 1):
		if number % i == 0:
			factors.append(i)
	return factors
number=int(input("enter a number:"))
factors=find_factors(number)
print("factors of", number, "are:", factors)
