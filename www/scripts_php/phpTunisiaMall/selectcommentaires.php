<?php
require_once('connect.php');

$idp=$_GET['idp'];

$sql = "SELECT u.username , c.body ,c.id , p.nom , p.id FROM comment c inner join user u on u.id=c.author_id inner join produit p on p.id= c.thread_id where p.id=$idp order by c.id desc";

$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $mydata = $xml->addChild('Comment');
        $mydata->addChild('username',$row['username']);
        $mydata->addChild('body',$row['body']);
	
      
         
}

} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>