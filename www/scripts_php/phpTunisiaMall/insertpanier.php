<?php
require_once('connect.php');
$idclient=$_GET['idclient'];
$idp=$_GET['idp'];


$quantite=$_GET['quantite'];

$sql = "insert into panier( `ID_CLIENT`, `ID_PRODUIT`, `QUANTITE`) values( $idclient , $idp , $quantite)";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>