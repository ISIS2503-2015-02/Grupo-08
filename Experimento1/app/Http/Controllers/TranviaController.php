<?php

namespace App\Http\Controllers;

use App\User;
use Illuminate\Http\Request;

class TranviaController extends Controller
{

    public function showInfo ($id)
    {
        $tranvia = \App\Tranvia::find($id);
        return json_encode($tranvia);
    }

    public function reportarPosicion (Request $request, $id)
    {
        $input = json_decode($request->getContent(), true);
        $tranvia = \App\Tranvia::find($id);
        $tranvia->latitud = $input["lat"];
        $tranvia->longitud = $input["long"];
        $tranvia->save();

        return ["estado"=>"OK","mensaje"=>"Se ha actualizado la posición del tranvia"];
    }

    public function reportarEmergencia ($id)
    {
        $tranvia = \App\Tranvia::find($id);
        $tranvia->emergencia = true;
        $tranvia->save();

        return ["estado"=>"OK","mensaje"=>"Se ha reportado la emergencia"];
    }

}