<?php

namespace App\Http\Controllers;

use App\Sayur;
use Illuminate\Http\Request;

class HomeController extends Controller
{
    public function __construct()
    {
       $this->middleware(['auth', 'admin']);
    }

    public function home()
    {
        $sayur = Sayur::all();
        return view('home',[
            'sayur' => $sayur
        ]);
    }
}
