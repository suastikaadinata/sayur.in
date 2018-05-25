<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Sayur extends Model
{
    protected $table = 'sayur';
    protected $fillable = [
        'nama', 'jumlah', 'berat', 'harga', 'foto',
    ];
}