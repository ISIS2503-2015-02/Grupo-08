<?php

namespace App\Http\Controllers;

use Laravel\Lumen\Routing\Controller as BaseController;

use Illuminate\Http\Request;

class MobibusController extends BaseController
{
    public function showInformacion ($id)
    {
        return "Informacion Mobibus $id";
    }
    public function reportarPosicionActual(Request $request, $id)
    {
       $input = $request->getContent();
       $json = json_decode($input);
       echo $json[0];
       echo "\n";
       
       return "se envia info de Mobibus $id";
    }
    public function reportarOcupacion(Request $request, $id)
    {
       $input = $request->getContent();
       $json = json_decode($input);
       echo $json[0];
       echo "\n";
       
       return "La ocupacion del Mobibus $id";
    }
}
