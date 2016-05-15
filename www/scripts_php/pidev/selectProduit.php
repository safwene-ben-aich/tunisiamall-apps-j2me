<?php
require_once('connect.php');



$sql = "SELECT * FROM produit";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $mydata = $xml->addChild('Produit');
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
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>