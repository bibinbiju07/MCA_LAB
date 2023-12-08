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
    $name = $_POST["name"];
    $from = $_POST["from"];
    $to = $_POST["to"];	
    $date = $_POST["date"];

$sql = "INSERT INTO airline (name, travel_From, travel_To, travel_date)VALUES ('$name', '$from', '$to', '$date')";

if ($conn->query($sql) == TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

    echo "<h2>Booking Details</h2>";
    echo "<p>Name: $name</p>";
    echo "<p>From: $from</p>";
    echo "<p>To: $to</p>";
    echo "<p>Date: $date</p>";
}
?>
