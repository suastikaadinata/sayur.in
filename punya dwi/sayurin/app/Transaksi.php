<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Transaksi extends Model
{
    protected $table = 'transaksi';
    protected $fillable = [
        'user_id', 'sayur_id', 'jumlah', 'total_harga', 'alamat', 'status_transaksi', 'metode_transaksi'
    ];
}
