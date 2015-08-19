<?php

namespace App\Http\Controllers;

use App\User;
use Illuminate\Http\Request;

class TranviaController extends Controller
{

    public function showInfo ($id)
    {
        return "info tranvia $id";
    }

    public function reportarPosicion (Request $request, $id)
    {
        $input = $request->getContent();
        $json = json_decode($input);
        echo $json[0];
        echo "\n";
        
        return "Se envia info de tranvia $id";
    }

    public function reportarEmergencia (Request $request, $id)
    {
        $input = $request->getContent();
        $json = json_decode($input);
        echo $json[0];
        echo "\n";

        return "Emergencia de tranvia $id" ;
    }

}