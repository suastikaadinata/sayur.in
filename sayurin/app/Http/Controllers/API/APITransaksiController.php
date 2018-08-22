<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Http\Controllers\API\KeranjangController as KeranjangController;
use App\Transaksi;
use App\Keranjang;
use App\CartTransaksi;
use DB;

class APITransaksiController extends KeranjangController
{
    public function transaksi(Request $request)
    {
        $this->cart($request);
        $user_id = $request->user_id;
        $data_cart = Keranjang::where('user_id',$user_id)->get();

        $transaksi = Transaksi::create([
            'user_id'           => $user_id,
            'alamat'            => $request->alamat,
            'metode_transaksi'  => 'COD',
            'waktu_pengiriman'  => $request->waktu_pengiriman,
        ]);

        for($i = 0; $i < count($data_cart); $i++){
            CartTransaksi::create([
                'transaksi_id'  => $transaksi->id,
                'sayur_id'      => $data_cart[$i]->sayur_id,
                'jumlah'        => $data_cart[$i]->jumlah_sayur,
                'total_harga'   => $data_cart[$i]->total_harga,
            ]);

            $data_cart[$i]->delete();
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
