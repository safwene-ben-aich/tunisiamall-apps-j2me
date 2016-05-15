<?php
require_once('connect.php');
$idclient=$_GET['idclient'];
$id=$_GET['id'];


$commentaire=$_GET['commentaire'];

$sql = "INSERT INTO `comment`(`thread_id`, `author_id`, `body`, `ancestors`, `depth`, `created_at`, `state`, `score`) VALUES ($id,$idclient,'$commentaire','',0,NOW(),0,0)";




echo $sql;
if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>