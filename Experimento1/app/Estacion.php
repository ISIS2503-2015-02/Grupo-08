<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Estacion extends Model {

    /**
     * The table associated with the model.
     *
     * @var string
     */
    protected $table = 'estaciones';

    /**
     * Indicates if the model should be timestamped.
     *
     * @var bool
     */
    public $timestamps = false;

}