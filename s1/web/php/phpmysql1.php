<!DOCTYPE html>
<html lang="eng">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Database Data</title>
<style>
 table {
	width: 50%;
	border-collapse: collapse;
	margin: 20px 0;
      }
table, th, td {
	border: 1px solid black;
	}
th, td {
	padding: 10px;
	text-align:left;
	}
</style>
</head>
<body>

<?php
$servername="localhost";
$username="root";
$password="";
$database="bibin";

$conn = new mysqli($servername,$username,$password,$database);

if($conn->connect_error){
  die("connection failed:".$conn->connect_error);
}

$sql="select * from student";
$result=$conn->query($sql);

if($result->num_rows > 0) {
  echo "<table><tr><th>id</th><th>name</th><th>rollno</th><th>phone</th></tr>";

while($row=$result->fetch_assoc()) {
echo "<tr><td>".$row["id"]."</td><td>".$row["name"]."</td><td>".$row["rollno"]."</td> <td>".$row["phone"]."</td></tr>";
}
echo "</table>";
} else {
echo "0 results found";
}


$conn->close();
?>

</body>
</html>
