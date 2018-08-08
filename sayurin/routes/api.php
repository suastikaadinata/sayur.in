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
Route::post('user/edit','API\APIUserController@editUser');
Route::post('sayur/search', 'API\JualSayurController@searchSayur');

Route::middleware('auth:api')->group( function() {
    Route::get('sayur', 'API\APISayurController@show');
    Route::post('sayur/tambah-sayur', 'API\APISayurController@adminTambahSayur');
    Route::post('sayur/delete', 'API\JualSayurController@delete');
    Route::post('sayur/detail', 'API\JualSayurController@spesificSayur');
    Route::post('sayur/edit', 'API\APISayurController@editSayur');
    Route::post('sayur/gudang/search', 'API\APISayurController@searchSayur');
    Route::get('user', 'API\APIUserAdminController@listUser');
    Route::post('user/delete', 'API\APIUserAdminController@deleteUser');
    Route::post('user/detail', 'API\APIUserAdminController@detailUser');
    Route::post('user/search', 'API\APIUserAdminController@searchUser');
});
