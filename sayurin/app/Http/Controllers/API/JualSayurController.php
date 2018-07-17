<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\SayurMobile;

class JualSayurController extends BaseController
{
    public function sayurmobile()
    {
        $sayurmobile = SayurMobile::all();
        return $this->sendResponse($sayurmobile);
    }
}
