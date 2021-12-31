<?php
    $dns = "mysql:host=localhost;dbname=tester";
    $email= $_POST['email'];
    $pwd= $_POST ['pwd'];

    $option = array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION);
   try{
    $pdo= new PDO($dns, $email, $pwd, $option);
     }catch(PDOException $e){
    echo 'erreur de connexion';
}

?>