<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Keranjang extends Model
{
    protected $table = 'keranjang';
    protected $fillable = [
        'user_id', 'sayur_id', 'jumlah', 'total_harga', 'order', 'status', 'isDeliver', 'kode_belanja',
    ];

    public function user()
    {
        return $this->belongsTo(User::class);
    }

    public function sayur()
    {
        return $this->belongsTo(Sayur::class);
    }

    public function order()
    {
        $this->order = 1;
        $this->save();
    }

    public function status()
    {
        $this->status = 1;
        $this->save();
    }

    public function isDeliver()
    {
        $this->isDeliver = 1;
        $this->save();
    }
}
