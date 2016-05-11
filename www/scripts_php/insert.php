<?php
require_once('Config.php');


$references = $_GET['references'];
$nom = $_GET['nom'];
$type = $_GET['type'];
$prix = $_GET['prix'];
$tauxReduction = $_GET['tauxreduction'];
$nombrePoint = $_GET['nombrePoint'];
$quantite = $_GET['quantite'];
$description = $_GET['description'];
$idMarque = $_GET['idMarque'];







$sql = "INSERT INTO PRODUIT (REFERENCE, ID_MARQUE, NOM, TYPE, PRIX, TAUX_REDUCTION, NOMBRE_POINT, PHOTO, DESCRIPTION, QUANTITE, QUANTITE_VENDU)
VALUES ( '$references','$idMarque' , '$nom', '$type', '$prix' , '$tauxReduction' , '$nombrePoint', NULL, '$description', '$quantite' , 0)";

if (mysqli_query($conn, $sql)) {
    echo "successfully added";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>