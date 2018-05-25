<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function manageUser()
    {
        return view('manage-user');
    }
}
