<?php

   function clean_champs( $champs ): string{
    return htmlentities(addslashes($champs));
  }

    function generateRandomNumber($length = 15) {
        $numbers = '0123456789';
        $numberslenght= strlen($numbers);
        $randomNumber = '';
        for ($i = 0; $i < $length; $i++) {
            $randomNumber .= $numbers[rand(0, $numberslenght - 1)];
        }
        return $randomNumber;
    }
?>