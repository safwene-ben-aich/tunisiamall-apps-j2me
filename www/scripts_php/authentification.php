<?php

//Auteur : Ben Aich Safwene le 10/05/2016

require_once('Config.php');

class authentification{
    private  $connexion;
    private  $username;
    private  $password;


    public function __construct()
    {
        $this->connexion = (new Config())->connexion();
        $this->username = "";
        $this->password = "";
    }

    public function getUserSalt()
{
    $statement = $this->connexion->prepare("SELECT * FROM USER WHERE USERNAME=:USERNAME");
    $statement->bindValue(':USERNAME',$this->getUsername(),PDO::PARAM_STR);
    $statement->execute();

    if ($statement->rowCount()>0) {
        while($row = $statement->fetch()) {
            return  ($row['salt']);
        }
    }
    else {
        return "false";
    }
}
    public function getUserSRole()
    {
        $statement = $this->connexion->prepare("SELECT * FROM USER WHERE USERNAME=:USERNAME");
        $statement->bindValue(':USERNAME',$this->getUsername(),PDO::PARAM_STR);
        $statement->execute();

        if ($statement->rowCount()>0) {
            while($row = $statement->fetch()) {
                return  ($row['ROLE']);
            }
        }
        else {
            return "false";
        }
    }

    public function getUserHaschedPassword()
    {
        $statement = $this->connexion->prepare("SELECT * FROM USER WHERE USERNAME=:USERNAME");
        $statement->bindValue(':USERNAME',$this->getUsername(),PDO::PARAM_STR);
        $statement->execute();

        if ($statement->rowCount()>0) {
            while($row = $statement->fetch()) {
                return  ($row['password']);
            }
        }
        else {
            return "false";
        }
    }
    public function verifyPasswordAndhashchedPassword()
    {


        if (hash('sha512',$this->getPassword().'{'.$this->getUserSalt().'}') == $this->getUserHaschedPassword()){
                    return $this->getUserSRole();
        }
        else {
        echo "false";
        }
    }







    public function getPassword()
    {
        return $this->password;
    }

    public function setPassword($password)
    {
        $this->password = $password;
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
        return 'Authentification <br> Username : '.$this->username.'<br> password : '.$this->password.'<br>';
    }
}

if(isset($_GET['username'])) {
    $username = $_GET['username'];
}
else{
    $username = '';
}
if(isset($_GET['password'])) {
    $password = $_GET['password'];
}
else{
    $password = '';
}


$authentification = new authentification();
$authentification->setUsername($username);
$authentification->setPassword($password);

echo $authentification->verifyPasswordAndhashchedPassword();






?>