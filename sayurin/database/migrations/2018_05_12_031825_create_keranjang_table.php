<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateKeranjangTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('keranjang', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('user_id')->unsigned();
            $table->integer('sayur_id')->unsigned();
            $table->integer('jumlah');
            $table->integer('total_harga');
            $table->boolean('order')->default(0);//status sudah di order atau belum
            $table->boolean('status')->default(0);//status sudah di bayar atau belum
            $table->boolean('isDeliver')->default(0);//status sudah terkirim atau belum
            $table->string('kode_belanja'); 
            $table->timestamps();

            $table->foreign('user_id')->references('id')->on('users')->onDelete('cascade');
            $table->foreign('sayur_id')->references('id')->on('sayur')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('keranjang');
    }
}
