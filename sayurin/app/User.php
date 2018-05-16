<?php

namespace App;

use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;

class User extends Authenticatable
{
    use Notifiable;

    protected $fillable = [
        'name', 'email', 'nomor_telepon','password', 'foto', 'tipe', 
    ];

    protected $hidden = [
        'password', 'remember_token',
    ];

    public function isAdmin()
    {
        return $this->tipe == 'admin';
    }

    public function foto()
    {
        if($this->foto == null){
            //return '/images/default-profile.png';
        }else{
            //return '/images/' . $this->foto;
        }
    }

    public function karanjang()
    {
        return $this->hasMany(Keranjang::class);
    }

    public function pembayaran()
    {
        return $this->hasMany(Pembayaran::class);
    }

    public function pengiriman()
    {
        return $this->hasMany(Pengiriman::class);
    }

    public function chatting()
    {
        return $this->hasMany(Chatting::class);
    }
}
