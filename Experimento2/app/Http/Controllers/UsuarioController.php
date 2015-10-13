<?php

namespace App\Http\Controllers;

use Laravel\Lumen\Routing\Controller as BaseController;

class UsuarioController extends BaseController
{
    public function verEstado($usuarioId, $pedidoId) {
        $user = \App\Usuario::find($usuarioId);

        return $user->pedido;

        return ["estado"=>"OK", "mensaje"=>"Aqui deberia retornar el objeto json del pedido"];
    }

    public function solicitarMobibus($usuarioId, $lat, $long) {
        $user = \App\Usuario::find($usuarioId);

        $user->pedido = "Pedido en ($lat,$long)";

        $user->save();

        return ["estado"=>"OK","mensaje"=>"Se solicitó el mobibus segun la ubicación dada"];
    }
}
