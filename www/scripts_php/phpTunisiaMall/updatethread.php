<?php
require_once('connect.php');

$idp=$_GET['idp'];




$sql = "UPDATE `thread` SET `num_comments`=`num_comments`+1 ,`last_comment_at`=NOW() where `id`=$idp";




echo $sql;
if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>