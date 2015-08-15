<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$app->get('/', function () use ($app) {
    return $app->welcome();
});

$app->group(['prefix' => 'usuario'], function ($app) {

    $app->get('', function ($usuario_id)  {
        // Matches The "/usuario/id" URL
    });

    $app->get('verEstado',function ($usuario_id){
        // Matches The usuario/{usuario_id}/verEstado URL
    });

    $app->post('solicitarMobibus', function ($usuario_id)  {
        // Matches The usuario/{usuario_id}/solicitarMobibus URL
    });






});
