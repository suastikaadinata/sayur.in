@extends('layout')

@section('title', 'Tambah Sayur')

@section('content')
    <div style="margin-bottom: 20px;" class="all-header">
        <div class="container">
           <h1>Detail Transaksi</h1>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
                    <div class="col-lg-3">
                        <span>dwi</span>
                        <br>
                        <span>083111</span>
                        <br>
                        <span>dwiemail@gmail.com</span>
                    </div>
                    <div class="col-lg-3">
                        <h3>Pesanan</h3>
                    </div>
                    <table style="text-align: center;" class="table table-bordered table-light table-striped">
                    <thead>
                        <tr class="table-success">
                            <th scope="col">Sayur</th>
                            <th scope="col">Jumlah</th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>
                    <tbody >
                    @for($i = 0; $i < 2; $i++)
                        <tr>
                            <td>bayam</td>
                            <td>3</td>
                            <td>15000</td>
                        </tr>
                    @endfor
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2">Total</td>
                            <td scope="">30000</td>
                        </tr>
                    </tfoot>
                </table>
                <div class="col-lg-3">
                        <h4>Metode pembayaran :</h4>
                        <span>On the spot</span>
                    </div>
                    <div class="row">
                        <div class="col-lg-5">
                        <h4>Status Transaksi :</h4>
                     <select class="col-lg-6 custom-select">
  <option value="1">Pengiriman</option>
  <option value="2">Menunggu Pembayaran</option>
  <option value="3">Terkonfirmasi</option>
</select>
<button class="col-lg-4 btn-success " style="text-align: center;">
    simpan
</button>
                   </div>
                   
                    </div>
                    
               
        </div>
    </div>
    <div class="modal fade" id="myModal" role="dialog" style="position: fixed; top: 50%;left: 50%;
  transform: translate(-50%, -50%);
">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <p>anda yakin ingin menghapus -SAYUR</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Yakin</button>
          <button type="button" class="btn btn-default btn-warning" data-dismiss="modal">Batal</button>
        </div>
      </div>
    </div>
  </div>
</div>
@endsection