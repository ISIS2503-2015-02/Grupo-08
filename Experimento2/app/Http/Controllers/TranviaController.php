<?php

namespace App\Http\Controllers;

use App\User;
use Illuminate\Http\Request;

class TranviaController extends Controller
{

    public function showAll() {
        $tranvias = \App\Tranvia::all('id', 'tiempoSalida', 'tiempoLlegada', 'linea','longitud', 'latitud', 'emergencia');
        return json_encode($tranvias);
    }

    public function showInfo ($id) {
        $tranvia = \App\Tranvia::find($id);
        return json_encode($tranvia);
    }

    public function reportarPosicion (Request $request, $id) {
        $input = json_decode($request->getContent(), true);
        $tranvia = \App\Tranvia::find($id);
        $vars = explode(",", $input["posicion"]);
        $tranvia->latitud = $vars[0];
        $tranvia->longitud = $vars[1];
        $tranvia->save();

        return ["estado"=>"OK","mensaje"=>"Se ha actualizado la posición del tranvia"];
    }

    public function reportarEmergencia (Request $request, $id) {
        $input = json_decode($request->getContent(), true);
        $tranvia = \App\Tranvia::find($id);
        $tranvia->emergencia = true;
        $tranvia->save();

        return ["estado"=>"OK","mensaje"=>"Se ha reportado la emergencia"];
    }

}