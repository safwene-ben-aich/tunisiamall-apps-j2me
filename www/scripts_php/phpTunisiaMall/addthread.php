<?php
require_once('connect.php');
$id=$_GET['id'];
$permalink=$_GET['permalink'];



$sql = "INSERT INTO `thread`(`id`, `permalink`, `is_commentable`, `num_comments`, `last_comment_at`) VALUES ($id,'$permalink',1,0,NOW())";


echo $sql;


if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>