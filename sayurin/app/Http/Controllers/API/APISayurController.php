<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Sayur;
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
}
