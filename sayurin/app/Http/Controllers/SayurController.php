<?php

namespace App\Http\Controllers;

use App\Sayur;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Input;

class SayurController extends Controller
{
    public function __construct()
    {
        $this->middleware(['auth', 'admin']);
    }

    public function manageSayur()
    {
        $sayur = Sayur::all();
        return view('manage-sayur',[
            'sayur' => $sayur
        ]);
    }

    public function tambahSayur()
    {
        return view('tambah-sayur');
    }

    public function save(Request $request)
    {
        $validation = [
            'gambar-sayur'  =>  'required|image|max:2000',
            'nama'          =>  'required|string|max:191',
            'harga'         =>  'required|numeric',
            'stok'          =>  'required|numeric',
            'kuantitas'     =>  'required|numeric'
        ];

        $this->validate($request, $validation);
        
        $data = $request->all();

        if($request->hasFile('gambar-sayur')){
            $files = $request->file('gambar-sayur');
            $path = $files->store('sayur', 'uploads');
        }

        $sayur = Sayur::create([
            'nama'      => $data['nama'],
            'jumlah'    => $data['stok'],
            'berat'     => $data['kuantitas'],
            'harga'     => $data['harga'],
            'foto'      => $path
        ]);

        return redirect('/manage-sayur/tambah-sayur')->with('addSayur',['tambah']);
    }

    public function searchSayur()
    {
        $keyword = Input::get('search');
        $search = Sayur::where('nama',"LIKE","%$keyword%")->paginate(20);

        return view('search-sayur',[
            'keyword'   => $keyword,
            'search'    => $search
        ]);
    }

    public function sayurJson()
    {
        $sayur = Sayur::all();
        return response()->json($sayur,200);
    }
}
