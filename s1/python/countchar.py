input_string=input("enter a string:")
char_frequency= { }
for char in input_string:
	char_frequency[char]=char_frequency.get(chaer, 0) + 1
print("character frequency in the string:")
for char, frequency in char_frequency.items():
	print(f"'{char}': {frequency}")
