<?php
include 'Config.php';
include 'Produit.php';

class GestionProduits {
	
	private $connexion;
	public function __construct(){
				$this->connexion = (new Config())->connexion();
	}
	public function affichage(){
		$req="SELECT * FROM PRODUIT";
		$resultat = $this->connexion->query($req);
		$xml = new SimpleXMLElement('<xml/>');
     if ($resultat->rowCount() > 0) {
    // output data of each row
      while($row = $resultat->fetch(PDO::FETCH_ASSOC)) {
      $mydata = $xml->addChild('PRODUITS');
        $mydata->addChild('ID',$row['ID']);
		$mydata->addChild('REFERENCE',$row['REFERENCE']);
		$mydata->addChild('ID_MARQUE',$row['ID_MARQUE']);
        $mydata->addChild('NOM',$row['NOM']);
        $mydata->addChild('TYPE',$row['TYPE']);
        $mydata->addChild('PRIX',$row['PRIX']);
        $mydata->addChild('TAUX_REDUCTION',$row['TAUX_REDUCTION']);
        $mydata->addChild('NOMBRE_POINT',$row['NOMBRE_POINT']);
        $mydata->addChild('PHOTO',$row['PHOTO']);
        $mydata->addChild('DESCRIPTION',$row['DESCRIPTION']);
        $mydata->addChild('QUANTITE',$row['QUANTITE']);
        $mydata->addChild('QUANTITE_VENDU',$row['QUANTITE_VENDU']);
        }
} else {
    echo "0 results";
}
		header ("Content-Type:text/xml");
		echo($xml->asXML());
}

	public function ajouterProduit ($produit){
		$statement = $this->connexion->prepare("INSERT INTO PRODUIT (REFERENCE,ID_MARQUE,NOM,TYPE,PRIX,TAUX_REDUCTION,NOMBRE_POINT,PHOTO,DESCRIPTION,QUANTITE,QUANTITE_VENDU) VALUES (:REFERENCE,:ID_MARQUE,:NOM,:TYPE,:PRIX,:TAUX_REDUCTION,:NOMBRE_POINT,:PHOTO,:DESCRIPTION,:QUANTITE,:QUANTITE_VENDU)");
		
		$statement->bindValue(':REFERENCE',$produit->getReference(),PDO::PARAM_STR);
		$statement->bindValue(':ID_MARQUE',$produit->getIdMarque(),PDO::PARAM_INT);
		$statement->bindValue(':NOM',$produit->getNom(),PDO::PARAM_STR);
		$statement->bindValue(':TYPE',$produit->getType(),PDO::PARAM_STR);
		$statement->bindValue(':PRIX',$produit->getPrix(),PDO::PARAM_STR);
		$statement->bindValue(':TAUX_REDUCTION',$produit->getTauxReduction(),PDO::PARAM_STR);
		$statement->bindValue(':NOMBRE_POINT',$produit->getNombrePoint(),PDO::PARAM_INT);
		$statement->bindValue(':PHOTO',$produit->getPhoto(),PDO::PARAM_STR);
		$statement->bindValue(':DESCRIPTION',$produit->getDescription(),PDO::PARAM_STR);
		$statement->bindValue(':QUANTITE',$produit->getQuantite(),PDO::PARAM_INT);
		$statement->bindValue(':QUANTITE_VENDU',$produit->getQuantiteVendu(),PDO::PARAM_INT);
		
		return ($statement->execute());
	}
	
	
	public function modifierProduit($produit){
		$statement = $this->connexion->prepare("UPDATE PRODUIT SET ID_MARQUE=:ID_MARQUE, NOM=:NOM, TYPE=:TYPE, PRIX=:PRIX, TAUX_REDUCTION=:TAUX_REDUCTION, NOMBRE_POINT=:NOMBRE_POINT, PHOTO=:PHOTO, DESCRIPTION=:DESCRIPTION, QUANTITE=:QUANTITE WHERE REFERENCE=:REFERENCE");
		
		$statement->bindValue(':REFERENCE',$produit->getReference(),PDO::PARAM_STR);
		$statement->bindValue(':ID_MARQUE',$produit->getIdMarque(),PDO::PARAM_INT);
		$statement->bindValue(':NOM',$produit->getNom(),PDO::PARAM_STR);
		$statement->bindValue(':TYPE',$produit->getType(),PDO::PARAM_STR);
		$statement->bindValue(':PRIX',$produit->getPrix(),PDO::PARAM_STR);
		$statement->bindValue(':TAUX_REDUCTION',$produit->getTauxReduction(),PDO::PARAM_STR);
		$statement->bindValue(':NOMBRE_POINT',$produit->getNombrePoint(),PDO::PARAM_INT);
		$statement->bindValue(':PHOTO',$produit->getPhoto(),PDO::PARAM_STR);
		$statement->bindValue(':DESCRIPTION',$produit->getDescription(),PDO::PARAM_STR);
		$statement->bindValue(':QUANTITE',$produit->getQuantite(),PDO::PARAM_INT);
		
		return ($statement->execute());
	}
	
	public function supprimerProduit($reference){
		$statement = $this->connexion->prepare("DELETE FROM PRODUIT WHERE REFERENCE=:REFERENCE");
		$statement->bindValue(':REFERENCE',$reference,PDO::PARAM_INT);
		return ($statement->execute());
	}
	
	
	
	
	
}
	$gestionProduits = new GestionProduits();
	
	if(isset($_GET['operation'])) {
    $operation = $_GET['operation'];
    }
	else{
	$operation = '';
	}
	if ($operation == 'ajout'){
	
	if(isset($_GET['reference'])) {
    $reference = $_GET['reference'];
    } 
	else {
    $reference = '';
	}
	
	if(isset($_GET['idMarque'])) {
    $idMarque = $_GET['idMarque'];
    } 
	else {
    $idMarque = '';
	}
	
	
	if(isset($_GET['nom'])) {
    $nom = $_GET['nom'];
    } 
	else {
    $nom = '';
	}
	
	if(isset($_GET['type'])) {
    $type = $_GET['type'];
    } 
	else {
    $type = '';
	}
	
	if(isset($_GET['prix'])) {
    $prix = $_GET['prix'];
    } 
	else {
    $prix = '';
	}
	
	if(isset($_GET['tauxReduction'])) {
    $tauxReduction = $_GET['tauxReduction'];
    } 
	else {
    $tauxReduction = '';
	}
	
	if(isset($_GET['nombrePoint'])) {
    $nombrePoint = $_GET['nombrePoint'];
    } 
	else {
    $nombrePoint = '';
	}
	
	if(isset($_GET['quantite'])) {
    $quantite = $_GET['quantite'];
    } 
	else {
    $quantite = '';
	}
	
	if(isset($_GET['description'])) {
    $description = $_GET['description'];
    } 
	else {
    $description = '';
	}
	
	if(isset($_GET['id'])) {
    $id = $_GET['id'];
    } 
	else {
    $id = '';
	}
	
	if(isset($_GET['quantiteVendu'])) {
    $quantiteVendu = $_GET['quantiteVendu'];
    } 
	else {
    $quantiteVendu = 0;
	}
	
	
	
	
	$produit = new Produit($id,$reference,$nom,$idMarque,$type,$prix,$tauxReduction,$nombrePoint,'', $description, $quantite, $quantiteVendu);
	if ($gestionProduits->ajouterProduit($produit)){
		echo "Success";
	}
	else {
		echo "Error";
	}
	
	}
	

	else if ($operation == 'affiche'){
		$gestionProduits->affichage();
	}
	
	
	else if ($operation == 'modifie'){
		if(isset($_GET['reference'])) {
    $reference = $_GET['reference'];
    } 
	else {
    $reference = '';
	}
	
	if(isset($_GET['idMarque'])) {
    $idMarque = $_GET['idMarque'];
    } 
	else {
    $idMarque = '';
	}
	
	
	if(isset($_GET['nom'])) {
    $nom = $_GET['nom'];
    } 
	else {
    $nom = '';
	}
	
	if(isset($_GET['type'])) {
    $type = $_GET['type'];
    } 
	else {
    $type = '';
	}
	
	if(isset($_GET['prix'])) {
    $prix = $_GET['prix'];
    } 
	else {
    $prix = '';
	}
	
	if(isset($_GET['tauxReduction'])) {
    $tauxReduction = $_GET['tauxReduction'];
    } 
	else {
    $tauxReduction = '';
	}
	
	if(isset($_GET['nombrePoint'])) {
    $nombrePoint = $_GET['nombrePoint'];
    } 
	else {
    $nombrePoint = '';
	}
	
	if(isset($_GET['quantite'])) {
    $quantite = $_GET['quantite'];
    } 
	else {
    $quantite = '';
	}
	
	if(isset($_GET['description'])) {
    $description = $_GET['description'];
    } 
	else {
    $description = '';
	}
	$produit = new Produit(null,$reference,$nom,$idMarque,$type,$prix,$tauxReduction,$nombrePoint,'', $description, $quantite,null);
	if ($gestionProduits->modifierProduit($produit)){
		echo "Success";
	}
	else {
		echo "Error";
	}
	}
	else if ($operation == 'supprime'){
	if(isset($_GET['reference'])) {
    $reference = $_GET['reference'];
    } 
	else {
    $reference = '';
	}
	if ($gestionProduits->supprimerProduit($reference)){
	echo "Success";
	}
	else {
		echo "Error";
	}
	}		
	
	
	
	?>