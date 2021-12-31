<?php

   include('connect.php');

    if($pdo){
        if(isset($_POST['email']) AND isset ($_POST['pwd'])){
            if(!empty($_POST['email']) AND !empty ($_POST['pwd'])){
            
                $email=htmlentities(addslashes($_POST['email'])) ;
                $pwd=htmlentities(addslashes($_POST['pwd']));
            
                $req=$pdo->prepare("SELECT * FROM user WHERE email like '$email' and pwd like '$pwd' ");
                $req->execute(array( 'email' => $email , 'pwd' => $pwd));

            if($req->rowCount() > 0){
                echo"success";
            }else{
                echo"echec";
            }
        }
        
         }
    }else{
        echo"Probleme de connexion";
    }
  
?>