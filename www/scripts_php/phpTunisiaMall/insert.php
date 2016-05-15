<?php
require_once('connect.php');

$Nom=$_GET['Nom'];
$login=$_GET['login'];
$email=$_GET['email'];
$prenom=$_GET['prenom'];
$password=$_GET['password'];
$adresse=$_GET['adresse'];
$sexe=$_GET['sexe'];
$sql = "insert into user( `NOM`, `PRENOM`, `LOGIN`, `PASSWORD`, `MAIL`, `ADRESSE`, `ETAT`, `ROLE`,`SEXE`) values('$Nom','$prenom','$login','$password','$email','$adresse','1','Client','$sexe')";

if (mysqli_query($conn, $sql)) {
    echo "success";

} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>