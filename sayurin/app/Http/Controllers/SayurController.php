<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class SayurController extends Controller
{
    public function manageSayur()
    {
        return view('manage-sayur');
    }
}
