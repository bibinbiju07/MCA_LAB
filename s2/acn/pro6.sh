echo "Enter a String"
read input
reverse=$(echo $input | rev)
echo "reverse string is : $reverse"
if [ $input == $reverse ]
then
    echo "$input is palindrome"
else
    echo "$input is not palindrome"
fi

