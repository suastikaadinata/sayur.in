<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Keranjang;
use App\SayurMobile;

class KeranjangController extends BaseController
{
    public function cart(Request $request)
    {
        $user_id = $request->user_id;
        $sayur_cart = $request->sayur_id;
        $jumlah = $request->jumlah;

        for($i = 0; $i < count($sayur_cart); $i++){
            $sayur = SayurMobile::findOrFail($sayur_cart[$i]);
            $total_harga[$i] = $jumlah[$i] * $sayur->harga;

        	$keranjang = Keranjang::create([
                'user_id'       => $user_id,
                'sayur_id'      => $sayur->id,
                'jumlah'        => $jumlah[$i],
                'total_harga'   => $total_harga[$i],
            ]);
        }

        if($keranjang){
        	 return "success";
        }else{
        	return "gagal";
        }
       
    }

    public function getCart(Request $request)
    {
        $sayur = Keranjang::where('user_id', $request->id)->get();
        return $this->sendResponse($sayur);
    }
}
