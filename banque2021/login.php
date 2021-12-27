<?php 
$db = "banque2021";
$user = $_POST['user'];
$pass = $_POST['pass'];
$host = "localhost";

$connexion = mysqli_connect($host, "root", "", $db);
if($connexion){
    $sql = "SELECT * FROM user WHERE email like '$user' AND pwd like $pass";
    $resultat = mysqli_query( $connexion, $sql );
    if(mysqli_num_rows( $resultat ) > 0 ){
        echo "success";
    }else{
        echo "echec";
    }mysqli_close( $connexion );
}else{
    echo "Problème de connexion";
}