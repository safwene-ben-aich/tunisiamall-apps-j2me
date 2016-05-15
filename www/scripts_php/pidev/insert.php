<?php
require_once('connect.php');

$equipe1=$_GET['eq1'];
$equipe2=$_GET['eq2'];
$arbitre=$_GET['arb'];
$sql = "INSERT INTO t_match ( equipe_1, equipe_2, arbitre)
VALUES ( '$equipe1','$equipe2','$arbitre')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>