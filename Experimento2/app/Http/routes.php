<?php

use Carbon\Carbon;

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

$app->get('/login/{user}/{pass}', function($user, $pass) {
    if($user == "admin" && $pass == "123$") {
        echo md5("true");
    } else {
        echo "false";
    }
});

$app->get('/tranvia', 'TranviaController@showAll');
$app->get('/tranviaCuenta', 'TranviaController@count');
$app->get('/mobibus', 'MobibusController@showAll');
$app->get('/mobibusCuenta', 'MobibusController@count');
$app->get('/estacion', 'EstacionController@showAll');
$app->get('/estacionCuenta', 'EstacionController@count');

$app->group(['prefix' => 'usuario/{usuarioId}', 'namespace'=>'App\Http\Controllers'], function ($app) {
    $app->get('verEstado/{id}','UsuarioController@verEstado');
    $app->post('solicitarMobibus/{lat}/{long}', 'UsuarioController@solicitarMobibus');
});

$app->group(['prefix' => 'estacion/{estacionId}', 'namespace'=> 'App\Http\Controllers'], function ($app) {
    $app->get('/', 'EstacionController@showInfo');
    $app->put('pedirLlenado', 'EstacionController@pedirLlenado');
    $app->put('prestarVcub/{id}', 'EstacionController@prestarVcub');
    $app->put('recibirVcub/{id}', 'EstacionController@recibirVcub');
    $app->put('registrarVcubs', 'EstacionController@registrarVcubs');
});

$app->group(['prefix' => 'tranvia/{id}', 'namespace'=> 'App\Http\Controllers'], function ($app) {
    $app->get('/', 'TranviaController@showInfo');
    $app->post('emergencia', 'TranviaController@reportarEmergencia');
    $app->put('reportarPosicion', 'TranviaController@reportarPosicion');
});

$app->group(['prefix' => 'mobibus/{mobibusId}', 'namespace' => 'App\Http\Controllers'], function ($app) {
   $app->get('/', 'MobibusController@showInformacion');
   $app->put('reportarPosicion', 'MobibusController@reportarPosicionActual');
   $app->put('ocupacion', 'MobibusController@reportarOcupacion');
    
});