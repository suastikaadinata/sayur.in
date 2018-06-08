<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Auth::routes();
Route::get('/logout', 'Auth\LoginController@logout');

Route::get('/', 'HomeController@home');

Route::group(['prefix' => 'manage-sayur'], function(){
    Route::get('/', 'SayurController@manageSayur');
    Route::get('/tambah-sayur', 'SayurController@tambahSayur');
    Route::post('/tambah-sayur/tambah', 'SayurController@save');
    Route::get('/search', 'SayurController@searchSayur');
    Route::get('/json', 'SayurController@sayurJson');
});

Route::get('/manage-user', 'UserController@manageUser');


