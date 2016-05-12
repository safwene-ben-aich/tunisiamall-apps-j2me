<?php

class Client {

    private $id;
    private $cin;
    private $nom;
    private $prenom;
    private $password;
    private $qrcode;
    private $telephone;
    private $adresse;
    private $username;
    private $email;
    private $sexe;



    function __construct($id,$cin,$nom,$prenom,$password,$qrcode,$telephone,$adresse,$username,$email,$sexe)
    {
        $this->id = $id;
        $this->cin = $cin;
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->password = $password;
        $this->qrcode = $qrcode;
        $this->telephone = $telephone;
        $this->adresse = $adresse;
        $this->username = $username;
        $this->email = $email;
        $this->sexe = $sexe;

    }


    function __toString()
    {
    return "Client : <br> id :  ".$this->id."<br> CIN : ".$this->cin."<br> Nom : ".$this->nom." <br> Prenom : ".$this->prenom."<br> password : ".$this->password.
    "<br> qrcode : ".$this->qrcode."<br> telephone : ".$this->telephone."<br> adresse : ".$this->adresse."<br> username : ".$this->username."<br> sexe : ".$this->sexe."<br> mail : ".$this->email;
    }


    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getCin()
    {
        return $this->cin;
    }

    /**
     * @param mixed $cin
     */
    public function setCin($cin)
    {
        $this->cin = $cin;
    }

    /**
     * @return mixed
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @param mixed $nom
     */
    public function setNom($nom)
    {
        $this->nom = $nom;
    }

    /**
     * @return mixed
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * @param mixed $prenom
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;
    }

    /**
     * @return mixed
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * @param mixed $password
     */
    public function setPassword($password)
    {
        $this->password = $password;
    }

    /**
     * @return mixed
     */
    public function getQrcode()
    {
        return $this->qrcode;
    }

    /**
     * @param mixed $qrcode
     */
    public function setQrcode($qrcode)
    {
        $this->qrcode = $qrcode;
    }

    /**
     * @return mixed
     */
    public function getTelephone()
    {
        return $this->telephone;
    }

    /**
     * @param mixed $telephone
     */
    public function setTelephone($telephone)
    {
        $this->telephone = $telephone;
    }

    /**
     * @return mixed
     */
    public function getAdresse()
    {
        return $this->adresse;
    }

    /**
     * @param mixed $adresse
     */
    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;
    }

    /**
     * @return mixed
     */
    public function getUsername()
    {
        return $this->username;
    }

    /**
     * @param mixed $username
     */
    public function setUsername($username)
    {
        $this->username = $username;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getSexe()
    {
        return $this->sexe;
    }

    /**
     * @param mixed $sexe
     */
    public function setSexe($sexe)
    {
        $this->sexe = $sexe;
    }

}









?>