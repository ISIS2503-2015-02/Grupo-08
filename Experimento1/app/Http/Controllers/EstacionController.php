<?php

namespace App\Http\Controllers;

use Laravel\Lumen\Routing\Controller as BaseController;

use Illuminate\Http\Request;

class EstacionController extends BaseController {

    public function showInfo ($estacionId) {
        $estacion = \App\Estacion::find($estacionId);
        return json_encode($estacion);
    }

    public function pedirLlenado($estacionId) {
        \App\Estacion::where("id", $estacionId)->update(["llenar"=>true]);

        return ["estado"=>"OK", "mensaje"=>"Se ha solicitado el llenado"];
    }

    public function prestarVcub($estacionId, $vcubId) {
        \App\Estacion::find($estacionId)->decrement("disponibles");

        return ["estado"=>"OK", "mensaje"=>"Se ha prestado el VCUB $vcubId"];
    }

    public function recibirVcub($estacionId, $vcubId) {
        \App\Estacion::find($estacionId)->increment("disponibles");

        return ["estado"=>"OK", "mensaje"=>"Se ha recibido el VCUB $vcubId"];
    }

    public function registrarVcubs(Request $request, $estacionId) {
        $input = $request->getContent();
        $json = json_decode($input);

        $estacion = \App\Estacion::find($estacionId);

        $estacion->disponibles = $estacion->disponibles+sizeof($json);

        $estacion->save();

        return ["estado"=>"OK", "mensaje"=>"Se han recibido los VCUBs"];
    }
}
