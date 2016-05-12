<?php
/**
 * Created by PhpStorm.
 * User: Safwene
 * Date: 12/05/2016
 * Time: 01:44
 */
include 'Config.php';
include 'Client.php';

class GestionClient{

    private $connexion;

    public function __construct(){
        $this->connexion = (new Config())->connexion();
    }

    public function ajouterProduit ($client){

        $salt = bin2hex(openssl_random_pseudo_bytes(16));

        $statement = $this->connexion->prepare("INSERT INTO USER (CIN,NOM,PRENOM,SEXE,USERNAME,USERNAME_CANONICAL,PASSWORD,QRCODE,EMAIL,EMAIL_canonical,ENABLED,SALT,LOCKED,EXPIRED,ROLES,CREDENTIALS_EXPIRED,ADRESSE,TELEPHONE,IMAGE,ROLE,ETAT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        $statement->bindValue(1, $client->getCin(),PDO::PARAM_STR);
        $statement->bindValue(2, $client->getNom(),PDO::PARAM_STR);
        $statement->bindValue(3, $client->getPrenom(),PDO::PARAM_STR);
        $statement->bindValue(4, $client->getSexe(), PDO::PARAM_STR);
        $statement->bindValue(5, $client->getUsername(), PDO::PARAM_STR);
        $statement->bindValue(6, $client->getUsername()."canonical", PDO::PARAM_STR);
        $statement->bindValue(7, hash('sha512',$client->getPassword().'{'.$salt.'}'), PDO::PARAM_STR);
        $statement->bindValue(8, $client->getQrcode(), PDO::PARAM_STR);
        $statement->bindValue(9, $client->getEmail(), PDO::PARAM_STR);
        $statement->bindValue(10, $client->getEmail()."canonical", PDO::PARAM_STR);
        $statement->bindValue(11, 1, PDO::PARAM_INT);
        $statement->bindValue(12, $salt , PDO::PARAM_STR);
        $statement->bindValue(13, 0, PDO::PARAM_INT);
        $statement->bindValue(14, 0, PDO::PARAM_INT);
        $statement->bindValue(15, 0, PDO::PARAM_INT);
        $statement->bindValue(16, 0, PDO::PARAM_INT);
        $statement->bindValue(17, $client->getAdresse(), PDO::PARAM_STR);
        $statement->bindValue(18, $client->getTelephone(), PDO::PARAM_STR);
        $statement->bindValue(19, "", PDO::PARAM_STR);
        $statement->bindValue(20, "CLIENT", PDO::PARAM_STR);
        $statement->bindValue(21, 1, PDO::PARAM_INT);


        //      prepp.setString(7,  sha.get_SHA_512_SecurePassword(r.getPassword(), salt));

        if ($statement->execute()){
            echo "good";
        }
        else
        {
            echo "false";
            $arr = $statement->errorInfo();
            print_r($arr);
        }
    }



}
if(isset($_GET['nom'])) {
    $nom = $_GET['nom'];
}
else {
    $nom = '';
}
if(isset($_GET['prenom'])) {
    $prenom = $_GET['prenom'];
}
else {
    $prenom = '';
}
if(isset($_GET['cin'])) {
    $cin = $_GET['cin'];
}
else {
    $cin = '';
}
if(isset($_GET['sexe'])) {
    $sexe = $_GET['sexe'];
}
else {
    $sexe = '';
}
if(isset($_GET['adresse'])) {
    $adresse = $_GET['adresse'];
}
else {
    $adresse = '';
}
if(isset($_GET['email'])) {
    $email = $_GET['email'];
}
else {
    $email = '';
}
if(isset($_GET['telephone'])) {
    $telephone = $_GET['telephone'];
}
else {
    $telephone = '';
}
if(isset($_GET['qrcode'])) {
    $qrcode = $_GET['qrcode'];
}
else {
    $qrcode = '';
}
if(isset($_GET['username'])) {
    $username = $_GET['username'];
}
else {
    $username = '';
}
if(isset($_GET['password'])) {
    $password = $_GET['password'];
}
else {
    $password = '';
}



$gestionClients = new GestionClient();
$client = new Client(null,$cin,$nom,$prenom,$password,$qrcode,$telephone,$adresse,$username,$email,$sexe);
echo $client;
$gestionClients->ajouterProduit($client);





?>