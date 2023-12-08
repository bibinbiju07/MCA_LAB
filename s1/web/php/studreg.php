
<?php
$servername="localhost";
$username="root";
$password="";
$database="bibin";

$conn = new mysqli($servername,$username,$password,$database);

if($conn->connect_error){
  die("connection failed:".$conn->connect_error);
}


if($_POST){
	$name = $_POST["name"];
	$address = $_POST["address"];
	$email = $_POST["email"];
	$mob = $_POST["mob"];
	
	
$sql = "INSERT INTO student (name, address, email, mob)
VALUES ('$name', '$address', '$email', '$mob')";

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}
}
?>
