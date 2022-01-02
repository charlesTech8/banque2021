<?php
    include('fonctions.php');
  //  echo generateRandomNumber();
    include('connect.php');

    if (isset($_POST['nom']) && isset($_POST['prenom']) && isset($_POST['adresse']) && isset($_POST['email']) && isset($_POST['phone']) && isset($_POST['pwd'])) {
      if (!empty($_POST['nom']) && !empty($_POST['prenom']) && !empty($_POST['adresse']) && !empty($_POST['email']) && !empty($_POST['phone']) && !empty($_POST['pwd'])) {

        $numCompte = generateRandomNumber();
        $nom = clean_champs($_POST['nom']);
        $prenom = clean_champs($_POST['prenom']);
        $adresse = clean_champs($_POST['adresse']);
        $email = clean_champs($_POST['email']);
        $phone = clean_champs($_POST['phone']);
        $pwd = clean_champs($_POST['pwd']);

        $req = $pdo->prepare('INSERT INTO client (numeroCompte,nom,prenom,adresse,email,telephone,pwd) VALUES (:numeroCompte,:nom,:prenom,:adresse,:email,:telephone,:pwd)');
        $ex = $req->execute(array('numeroCompte'=>$numCompte,
                                  'nom'=>$nom,
                                  'prenom'=>$prenom,
                                  'adresse'=>$adresse,
                                  'email'=>$email,
                                  'telephone'=>$phone,
                                  'pwd'=>$pwd ));
        if ($ex) {
          echo ("Compte créer avec succès");
        } else {
          echo ("Echec de la création du compte");
        }
      }
    }
?>
