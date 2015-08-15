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

$app->group(['prefix' => 'usuario/{usuarioId}', 'namespace'=>'App\Http\Controllers'], function ($app) {

    $app->get('/','UsuarioController@darUsuario');
    $app->get('verEstado/{id}','UsuarioController@verEstado');
    $app->get('solicitarMobibus/{lat}/{long}', 'UsuarioController@solicitarMobibus');
});

$app->group(['prefix' => 'estacion/{estacionId}', 'namespace'=> 'App\Http\Controllers'], function ($app) {
    $app->get('pedirLlenado', 'EstacionController@pedirLlenado');
    $app->get('prestarVcub/{id}', 'EstacionController@prestarVcub');
    $app->get('recibirVcub/{id}', 'EstacionController@recibirVcub');
    $app->post('registrarVcubs', 'EstacionController@registrarVcubs');

});
