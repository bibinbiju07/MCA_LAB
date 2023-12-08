<?php
$servername = "localhost";
$username = "root";
$password = "";
$db = "bibin";


$conn = new mysqli($servername, $username, $password,$db);


if($conn->connect_error){
  die("connection failed:".$conn->connect_error);
} else {
echo "connected successfully";
}


if ($_POST) {
    $isbn = $_POST["isbn"];
    $title = $_POST["title"];
    $author = $_POST["author"];	
    $edition = $_POST["edition"];
    $pubisher = $_POST["publisher"];		

$sql = "INSERT INTO library (isbn, title, author, edition, publisher)VALUES ('$isbn', '$title', '$author', '$edition',   '$publisher')";

if ($conn->query($sql) == TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

}
?>
