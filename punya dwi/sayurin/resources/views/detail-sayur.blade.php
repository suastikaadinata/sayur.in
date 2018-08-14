@extends('layout')

@section('title', 'Tambah Sayur')

@section('content')
    <div style="margin-bottom: 20px;" class="all-header">
        <div class="container">
           <h1>Detail Sayur</h1>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="image-place-upload"></div>
                    </div>
                    <div class="col-lg-5">  
                        <h4>Nama Sayur</h4>
                        <div>
                            <h5 style="color: #e67e22" >nama sayur</h5>
                        </div>
                            
                        <h4>Harga Sayur</h4>
                        <div>
                            <h5 style="color: #e67e22">Rp. 10.000</h5>
                        </div>

                        <h4>Stok Sayur</h4>
                        <div>
                            <h5 style="color: #e67e22">50</h5>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <h4>Kuantitas Sayur</h4>
                        <div>
                            <h5 style="color: #e67e22"  >Ikat</h5>
                        </div>
                        <button onclick="window.location.href='/manage-sayur/edit-sayur'" class="btn btn-default btn-lg btn-modif btn-tambah-sayur">
                            Edit
                        </button>
                        <button class="btn btn-default btn-lg btn-modif-hapus" data-toggle="modal" data-target="#myModal">
                            Hapus
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