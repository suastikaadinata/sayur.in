var tempImageUpload = 0;
var addSayur = $('#addSayur').val();
$('#text-upload').text("Upload Gambar");

$(function() {
    var imagesPreview = function(input, placeToInsertImagePreview) {

        if (input.files) {
            if(tempImageUpload > 0){
                $('.image-place-upload img:last-child').remove();
            }

            for (i = 0; i <= 1; i++) {
                var reader = new FileReader();

                reader.onload = function(event) {
                    $($.parseHTML('<img>')).attr('src', event.target.result).appendTo(placeToInsertImagePreview);
                    tempImageUpload = 1;
                }
                var filename = $('input[type=file]').val().split('\\').pop();
                reader.readAsDataURL(input.files[i]);
                $('#text-upload').text(filename);
            }
       
        }
    };

    $('#uploadPhotoSayur').on('change', function() {
        imagesPreview(this, 'div.image-place-upload');
    });
});

if(addSayur == 1){
    $('#modal-add-sayur').modal('toggle');
}
