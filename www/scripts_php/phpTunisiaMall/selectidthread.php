<?php
require_once('connect.php');

$idp=$_GET['idp'];

$sql = "SELECT * FROM  Thread  where id=$idp";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
   echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
mysqli_close($conn);
?>