<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Transaksi;
use DB;

class TransaksiController extends Controller
{    
    public function __construct()
    {
        $this->middleware(['auth', 'admin']);
    }

    public function manageTransaksi()
    {
        $belumdibayar = count(Transaksi::where('status_transaksi', 0)->get());
        $sukses = count(Transaksi::where('status_transaksi', 2)->get());
        return view('manage-transaksi', [
            'belumdibayar'      => $belumdibayar,
            'sukses'            => $sukses,
        ]);
    }
    public function detilTransaksi()
    {
        return view('detail-transaksi');
    }

    public function belumBayar()
    {
        $belumdibayar = DB::table('transaksi')
        ->where('transaksi.status_transaksi', 0)
        ->leftJoin('cart_transaksi','transaksi.id','=','cart_transaksi.transaksi_id')
        ->leftJoin('users','transaksi.user_id','=','users.id')
        ->select('transaksi.*', 'cart_transaksi.transaksi_id', 'cart_transaksi.jumlah_sayur', 'cart_transaksi.total_harga', 'users.name')
        ->get();
        //header('Content-Type: application/json');
        return response()->json($belumdibayar, 200);
    }

    public function sudahBayar()
    {
        $sudahdibayar = DB::table('transaksi')
        ->where('transaksi.status_transaksi', 2)
        ->leftJoin('cart_transaksi','transaksi.id','=','cart_transaksi.transaksi_id')
        ->leftJoin('users','transaksi.user_id','=','users.id')
        ->select('transaksi.*', 'cart_transaksi.transaksi_id', 'cart_transaksi.jumlah_sayur', 'cart_transaksi.total_harga', 'users.name')
        ->get();
        ///header('Content-Type: application/json');
        return response()->json($sudahdibayar, 200);
    }
}
