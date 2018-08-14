<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TransaksiController extends Controller
{    
    public function __construct()
    {
        $this->middleware(['auth', 'admin']);
    }

    public function manageTransaksi()
    {
        return view('manage-transaksi');
    }
    public function detilTransaksi()
    {
        return view('detail-transaksi');
    }
}
