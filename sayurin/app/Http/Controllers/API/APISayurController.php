<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Sayur;
use App\SayurMobile;
use Illuminate\Support\Facades\Auth;
use Validator;

class APISayurController extends BaseController
{
    public function __construct()
    {
        $this->middleware(['auth', 'admin']);
    }

    public function show()
    {
        $sayur = Sayur::all();
        return $this->sendResponse($sayur);
    }

    public function adminTambahSayur(Request $request)
    {
        $sayur = Sayur::findOrFail($request->id);

        $sayurmobile = SayurMobile::create([
            'nama'      => $sayur->nama,
            'jumlah'    => $sayur->jumlah,
            'berat'     => $sayur->berat,
            'harga'     => $sayur->harga,
            'foto'      => $sayur->foto,
        ]);

        $sayur->delete();

        return $this->sendResponse($sayur);
    }
}
