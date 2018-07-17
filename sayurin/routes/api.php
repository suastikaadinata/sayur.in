<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
Route::post('register', 'API\RegisterController@register');
Route::post('login', 'API\LoginController@login');
Route::get('sayur/dijual', 'API\JualSayurController@sayurmobile');

Route::middleware('auth:api')->group( function() {
    Route::get('sayur', 'API\APISayurController@show');
    Route::post('sayur/tambah-sayur', 'API\APISayurController@adminTambahSayur');
});
