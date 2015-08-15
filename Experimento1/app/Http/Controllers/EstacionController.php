<?php

namespace App\Http\Controllers;

use Laravel\Lumen\Routing\Controller as BaseController;

use Illuminate\Http\Request;

class EstacionController extends BaseController
{
    public function pedirLlenado($estacionId) {
        return ["estado"=>"OK", "mensaje"=>"Se ha solicitado el llenado"];
    }

    public function prestarVcub($estacionId, $vcubId) {
        return "OK $estacionId $vcubId";
    }

    public function recibirVcub($estacionId, $vcubId) {
        return "OK $estacionId $vcubId";
    }

    public function registrarVcubs(Request $request, $estacionId) {
        $input = $request->getContent();
        $json = json_decode($input);
        return "OK $estacionId";
    }
}
