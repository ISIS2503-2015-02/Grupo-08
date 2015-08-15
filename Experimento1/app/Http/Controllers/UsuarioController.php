<?php

namespace App\Http\Controllers;

use Laravel\Lumen\Routing\Controller as BaseController;

class UsuarioController extends BaseController
{
    public function darUsuario($usuarioId) {
        return ["estado"=>"OK", "mensaje"=>"Aqui deberia retornar el objeto json del usuario"];
    }

    public function verEstado($usuarioId, $pedidoId){
        return ["estado"=>"OK", "mensaje"=>"Aqui deberia retornar el objeto json del pedido"];
    }

    public function solicitarMobibus($usuarioId, $lat, $long){
        return ["estado"=>"OK","mensaje"=>"Se solicitó el mobibus segun la ubicación dada"];
    }
}
