echo "enter first number"
read a 
echo "enter second number"
read b
echo "enter third number"
read c
echo "enter fourth number"
read d
s=$(($a+$b+$c+$d))
p=$(($a*$b*$c*$d))
a=$(echo "scale=2;($s/4)" |bc)
echo "sum=" $s
echo "prdct=" $p
echo "avg=" $a 

