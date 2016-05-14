<?php
require_once('Config.php');

class GestionResponsable{
		private $connexion;
		private $username;

public function __construct()
{
	$this->connexion = (new Config())->connexion();
    $this->username = "";

}

public function getidMarqueResponsable()
    {
        $statement = $this->connexion->prepare("SELECT MARQUE.* FROM MARQUE,USER WHERE (USER.ID=MARQUE.ID_RESPONSABLE AND USER.username=:USERNAME)");
        $statement->bindValue(':USERNAME',$this->getUsername(),PDO::PARAM_STR);
        $statement->execute();

        if ($statement->rowCount()>0) {
            while($row = $statement->fetch()) {
                return  ($row['ID']);
            }
        }
        else {
            return "false";
        }
    }





 public function getUsername()
  {
        return $this->username;
    }

    public function setUsername($username)
    {
        $this->username = $username;
    }

  public function  __toString()
    {
        return 'Authentification <br> Username : '.$this->username;
    }
}


if(isset($_GET['username'])) {
    $username = $_GET['username'];
}
$gestionResponsable = new GestionResponsable();
$gestionResponsable->setUsername($username);

echo $gestionResponsable->getidMarqueResponsable();




?>