<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Usuario extends Model {

    /**
     * The table associated with the model.
     *
     * @var string
     */
    protected $table = 'usuarios';

    /**
     * Indicates if the model should be timestamped.
     *
     * @var bool
     */
    public $timestamps = false;

}