<?php
$db=new mysqli("localhost","root","","bibin");
if($db->connect_error){
die("connection failed".$db->connect_error)
}
$result=$db->query("select * from student");
while($row=$result->fetch_assoc()) {
echo "NAME".$row['name']."<br>"
}
$db->close();

?>

