<?php

include('connect.php');

  if (isset($_POST['nom']) && isset($_POST['prenom']) && isset($_POST['adresse']) && isset($_POST['email']) && isset($_POST['phone']) && isset($_POST['pwd'])){
    if (!empty($_POST['nom']) && !empty($_POST['prenom']) && !empty($_POST['adresse']) && !empty($_POST['email']) && !empty($_POST['phone']) && !empty($_POST['pwd'])){
    
        $nom = htmlentities(addslashes($_POST['nom']));
        $prenom = htmlentities(addslashes($_POST['prenom']));
        $adresse = htmlentities(addslashes($_POST['adresse']));
        $email = htmlentities(addslashes($_POST['email']));
        $phone = htmlentities(addslashes($_POST['phone']));
        $pwd = htmlentities(addslashes($_POST['pwd']));

        $req=$pdo->prepare('INSERT INTO client (nom,prenom,adresse,email,telephone,pwd) VALUES (?,?,?,?,?,?)');
        $req->execute(array('nom' =>$nom ,
                            'prenom' =>$nom,
                            'adresse' =>$adresse,
                            'email' =>$email,
                            'telephone' =>$phone,
                            'pwd' =>$pwd
        
         ));

         if($req->rowCount() > 0){
            echo"Compte créer avec succes";
        }else{
            echo"Echec de la creation du compte";
        }

    }

  }



?>