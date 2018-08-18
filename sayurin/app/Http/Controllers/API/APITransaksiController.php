<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Transaksi;
use App\Keranjang;
use App\CartTransaksi;
use DB;

class APITransaksiController extends BaseController
{
    public function transaksi(Request $request)
    {
        $user_id = $request->user_id;
        $data_cart = Keranjang::all();

        $transaksi = Transaksi::create([
            'user_id'           => $user_id,
            'alamat'            => $request->alamat,
            'metode_transaksi'  => 'COD',
            'waktu_pengiriman'  => $request->waktu_pengiriman,
        ]);

        for($i = 0; $i < count($data_cart); $i++){
            if($data_cart[$i]->user_id == $user_id){
                CartTransaksi::create([
                    'transaksi_id'  => $transaksi->id,
                    'sayur_id'      => $data_cart[$i]->sayur_id,
                    'jumlah'        => $data_cart[$i]->jumlah,
                    'total_harga'   => $data_cart[$i]->total_harga,
                ]);

                $data_cart[$i]->delete();
            }
        }

        return 'success';
    }

    public function getDetailTransaksi(Request $request){
        $transaksi = DB::table('transaksi')
                    ->where('user_id', $request->id)
                    ->leftJoin('cart_transaksi','transaksi.id','=','cart_transaksi.transaksi_id')
                    ->get();
        return $this->sendResponse($transaksi);
    }

    public function getAllTransaksi(){
        $transaksi = Transaksi::all();
        return $this->sendResponse($transaksi);
    }
}
