<?php

Class Config{
	
	public function connexion(){
		$serverName = 'localhost';
		$userName = 'root';
		$password ='';
		$dbName ='tunisiamallbd';
		
		
		try {
		$bdd = new PDO("mysql:host=$serverName;dbname=$dbName",$userName,$password);
		//echo "Connexion effectue avec sucees !";
		}
		catch (Exception $e){
			die("Probl�me de connexion avec la base de donn�es".$e->getMessage());
			
		}
			return $bdd;
	}
}

/*
$config = new Config();
$config->connexion();
*/

?>