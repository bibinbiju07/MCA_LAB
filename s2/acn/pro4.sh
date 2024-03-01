
echo "enter the year:"
read n
num=$(( $n % 4 ))
 if [ $num -eq 0 ]
  then
    echo " it is leap year."
else
echo " it is not leap year."
fi
