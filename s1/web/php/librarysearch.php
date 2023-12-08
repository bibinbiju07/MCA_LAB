


<?php

$servername = "localhost";
$username = "root";
$password = "";
$db = "bibin";

$conn = new mysqli($servername, $username, $password,$db);

$search = $_POST['search'];
if($conn->connect_error){
  die("connection failed:".$conn->connect_error);
} 
		

$sql = "select * from library where title like '%$search%'";

$result = $conn->query($sql);

if ($result->num_rows > 0){
while($row = $result->fetch_assoc() ){


echo $row["isbn"]." ".$row["title"]."  ".$row["author"]."  ".$row["edition"]."  ".$row["publisher"]." <br>";


}
} else {
	echo "the book is not available";
}

$conn->close();


?>







