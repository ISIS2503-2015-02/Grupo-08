<?php

namespace App\Http\Controllers;

use Laravel\Lumen\Routing\Controller as BaseController;

use Illuminate\Http\Request;

class MobibusController extends BaseController
{
    public function showInformacion($id) {
        $mobibus = \App\Mobibus::find($id);
        return json_encode($mobibus);
    }

    public function reportarPosicionActual(Request $request, $id) {
        $input = json_decode($request->getContent(), true);
        $mobibus = \App\Mobibus::find($id);
        $mobibus->posicion = $input["posicion"];
        $mobibus->save();

        return ["estado"=>"OK","mensaje"=>"Se ha actualizado la posición del mobibus"];
    }

    public function reportarOcupacion(Request $request, $id) {
        $input = json_decode($request->getContent(), true);
        $mobibus = \App\Mobibus::find($id);
        $mobibus->posicion = $input["ocupacion"];
        $mobibus->save();

        return ["estado"=>"OK","mensaje"=>"Se ha actualizado la ocupación del mobibus"];
    }
}
