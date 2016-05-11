<?php

class Produit {
	
	private $id;
	private $reference;
	private $idMarque;
	private $nom;
	private $type;
	private $prix;
	private $tauxReduction;
	private $nombrePoint;
	private $photo;
	private $description;
	private $quantite;
	private $quantiteVendu;
	
	public function __construct($id,$reference,$nom,$idMarque,$type,$prix,$tauxReduction,$nombrePoint, $photo, $description, $quantite, $quantiteVendu){
		$this->id = $id;
		$this->reference = $reference;
		$this->idMarque = $idMarque;
		$this->nom = $nom;
		$this->type = $type;
		$this->prix = $prix;
		$this->tauxReduction = $tauxReduction;
		$this->nombrePoint = $nombrePoint;
		$this->photo = $photo;
		$this->description = $description;
		$this->quantite = $quantite;
		$this->quantiteVendu = $quantiteVendu;
	}
	

	public function __toString(){
		return 'Produit <br> La reference : '.$this->reference.'<br>L\'ID marque :'.$this->idMarque.'<br>le nom : '.$this->nom.'<br>Le type : '.$this->type.'<br>Le prix : '.$this->prix.'<br>Le taux de reduction : '.$this->tauxReduction.'<br>Le nombre de point : '.$this->nombrePoint.'<br>La photo : '.$this->photo.'<br>La description : '.$this->description.'<br>La quantite : '.$this->quantite.'<br>La quantite vendu : '.$this->quantiteVendu;
	}
	
	
	public function getID(){
		return $this->id;
	}
	public function setID($id){
		$this->id=$id;
	}
	
	
	public function getReference(){
		return $this->reference;
	}
	public function setReference($reference){
		$this->reference = $reference;
	}
	
	
	public function getIdMarque(){
		return $this->idMarque;
	}
	public function setIdMarque($idMarque){
		$this->idMarque=$idMarque;
	}
	
	public function getNom(){
		return $this->nom;
	}

	public function setNom($nom){
		$this->nom = $nom;
	}

	public function getType(){
		return $this->type;
	}

	public function setType($type){
		$this->type = $type;
	}

	public function getPrix(){
		return $this->prix;
	}

	public function setPrix($prix){
		$this->prix = $prix;
	}

	public function getTauxReduction(){
		return $this->tauxReduction;
	}

	public function setTauxReduction($tauxReduction){
		$this->tauxReduction = $tauxReduction;
	}

	public function getNombrePoint(){
		return $this->nombrePoint;
	}

	public function setNombrePoint($nombrePoint){
		$this->nombrePoint = $nombrePoint;
	}

	public function getPhoto(){
		return $this->photo;
	}

	public function setPhoto($photo){
		$this->photo = $photo;
	}

	public function getDescription(){
		return $this->description;
	}

	public function setDescription($description){
		$this->description = $description;
	}

	public function getQuantite(){
		return $this->quantite;
	}

	public function setQuantite($quantite){
		$this->quantite = $quantite;
	}

	public function getQuantiteVendu(){
		return $this->quantiteVendu;
	}

	public function setQuantiteVendu($quantiteVendu){
		$this->quantiteVendu = $quantiteVendu;
	}
	
}

//$produit = new Produit('ref12345','Produit',1,'THE',20.1,15,50, 'no photo', 'description produit test', 20, 0);
//echo $produit."<br>";






?>